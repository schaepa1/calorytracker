import { Product } from '@/model/product';
import { onMounted, ref } from 'vue';
import { IonButton, IonContent, alertController } from '@ionic/vue';
import { addNewProduct, getAllProducts, deleteProductWithID } from '@/api/products';
import { useRouter } from 'vue-router';
import axios from 'axios';

export function useProducts() {

    let products = ref<Product[]>([]);

    let newProduct = ref<Product>({});

    let selectedDate = ref<Date>(new Date());

    let isOpenModal = ref<boolean>(false);

    let barcode = ref<number>();

    const router = useRouter();

    const getProducts = async (date: Date) => {
        try {
            products.value = await getAllProducts(date);
        } catch (error) {
            console.log(error);
        }
    }

    const addProduct = async () => {
        try {
            let consumeDate = newProduct.value.productConsumeDate as string;
            let consumeDateFormatted = consumeDate.split("-").reverse().join(".");
            newProduct.value.productConsumeDate = consumeDateFormatted;
            await addNewProduct(newProduct.value).then(async () => {
                router.push('/tabs/dailyConsumption').then(async () => {
                    await getProducts(selectedDate.value);
                })
            });
        } catch (error) {
            console.log(error);
        }
    }

    const deleteProduct = async (id: any) => {
        try {
            await deleteProductWithID(id).then(async () => {
                await getProducts(selectedDate.value);
            });
        } catch (error) {
            console.log(error);
        }
    }

    const checkAnyProductsToday = function () {
        if (products.value.length > 0) {
            return true
        } else {
            return false
        }
    }

    const showConfirmDeletionAlert = async function (product: Product) {
        console.log(product);
        const alert = await alertController.create({
            header: 'Eintrag löschen',
            message: 'Willst du ' + product.productName + ' vom ' + product.productConsumeDate + ' endgültig löschen?',
            buttons: [
                {
                    text: 'Nein',
                },
                {
                    text: 'Ja',
                    handler: () => {
                        deleteProduct(product.productId)
                    }
                }
            ]
        });
        await alert.present();
    }

    const calculateDailyTotalCalories = function () {
        let total = 0;
        products.value.forEach((product: any) => {
            total += parseInt(product.productCalories, 10);
        })
        return total;
    }

    const closeModal = function () {
        isOpenModal.value = false;
    }

    const openModal = function () {
        isOpenModal.value = true;
    }

    const selectDate = function (date: any) {
        selectedDate.value = new Date(date.detail.value);
    }

    const confirmModal = async function () {
        closeModal();
        await getProducts(selectedDate.value);
    }

    const getProductInfo = async function () {
        try 
        {
            let url = 'https://world.openfoodfacts.org/api/v2/product/'+ barcode.value;
            const response = await axios.get(url);
            newProduct.value.productName = response.data.product.product_name;
            newProduct.value.productDescription = response.data.product.categories;
            newProduct.value.productCalories = response.data.product.nutriments.energy;
            let day = new Date().getDate();
            let dayString = day.toString();
            if(day < 10) {
              dayString = "0" + dayString;
            }
            let month = new Date().getMonth()+1;
            let monthString = month.toString();
            if(month < 10) {
              monthString = "0" + monthString;
            }
            let year = new Date().getFullYear();
            let todayDate = dayString + "." + monthString + "." + year;

            newProduct.value.productConsumeDate = todayDate;
            newProduct.value.productConsumeDate = newProduct.value.productConsumeDate.split("-").reverse().join(".");
            newProduct.value.productConsumeTime = new Date().getHours() + ":" + new Date().getMinutes()
            addProduct();
        } catch (error) {
            return error;
        }
    }

    const setBarcode = function (barcodeentry: any){
        barcode = barcodeentry;
        console.log("set barcode to "+barcode)
    }

    onMounted(() => getProducts(selectedDate.value));

    return {
        products,
        newProduct,
        getProducts,
        addProduct,
        calculateDailyTotalCalories,
        deleteProduct,
        showConfirmDeletionAlert,
        checkAnyProductsToday,
        isOpenModal,
        closeModal,
        openModal,
        selectedDate,
        selectDate,
        confirmModal,
        barcode,
        getProductInfo,
        setBarcode
    }
}