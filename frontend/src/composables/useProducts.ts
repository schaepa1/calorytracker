import { getAllProducts, addNewProduct } from '@/api/products';
import { Product } from '@/model/product';
import { onMounted, ref } from 'vue';

export function useProducts() {

    const products = ref<Product[]>([]);

    const newProduct = ref<Product>({});

    const getProducts = async () => {
        try {
            products.value = await getAllProducts();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const addProduct = async () => {
        try {
            // add the new todo and update the list of all todos afterwards
            await addNewProduct(newProduct.value);
            getProducts();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getProducts);

    return {
        newProduct,
        products,
        getProducts,
        addProduct,
    }
}