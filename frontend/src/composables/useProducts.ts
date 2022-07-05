import { Product } from '@/model/product';
import { onMounted, ref } from 'vue';
import { IonButton, IonContent, alertController } from '@ionic/vue';
import { addNewProduct, getAllProducts } from '@/api/products';

export function useProducts() {

    const products = ref<Product[]>([]);

    const newProduct = ref<Product>({});

    const getProducts = async () => {
        console.log("DOING GETPRODUCTS");
        try {
            products.value = await getAllProducts();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
        /*products.value = [
            {
                id: 1,
                productName: 'Essen 1',
                productDescription: 'Beschreibung 1',
                productCalories: 500,
                productConsumeDate: new Date().toISOString().split('T')[0],
                productConsumeTime: new Date().toLocaleTimeString().slice(0, 5),
            },
            {
                id: 2,
                productName: 'Essen 2',
                productDescription: 'Beschreibung 2',
                productCalories: 150,
                productConsumeDate: new Date().toISOString().split('T')[0],
                productConsumeTime: new Date().toLocaleTimeString().slice(0, 5),
            },
            {
                id: 3,
                productName: 'Essen 3',
                productDescription: 'Beschreibung 3',
                productCalories: 300,
                productConsumeDate: new Date().toISOString().split('T')[0],
                productConsumeTime: new Date().toLocaleTimeString().slice(0, 5),
            },
            {
                id: 4,
                productName: 'Essen 4',
                productDescription: 'Beschreibung 4',
                productCalories: 200,
                productConsumeDate: new Date().toISOString().split('T')[0],
                productConsumeTime: new Date().toLocaleTimeString().slice(0, 5),
            },];*/
    }

    const addProduct = async () => {
        try {
            // add the new todo and update the list of all todos afterwards
            let consumeDate = newProduct.value.productConsumeDate as string;
            let consumeDateFormatted = consumeDate.split("-").reverse().join(".");
            newProduct.value.productConsumeDate = consumeDateFormatted;
            console.log(newProduct.value);
            await addNewProduct(newProduct.value);
            getProducts();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
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
                        deleteProduct(product.id)
                    }
                }
            ]
        });
        await alert.present();
    }

    const deleteProduct = function (id: any) {
        console.log("PRODUKT GELÖSCHT MIT ID", id);
    }


    const calculateDailyTotalCalories = function () {
        let total = 0;
        products.value.forEach((product: any) => {
            total += parseInt(product.productCalories, 10);
        })
        return total;
    }

    onMounted(getProducts);

    return {
        products,
        newProduct,
        getProducts,
        addProduct,
        calculateDailyTotalCalories,
        deleteProduct,
        showConfirmDeletionAlert,
        checkAnyProductsToday,
    }
}