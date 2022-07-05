import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Product } from '@/model/product';

export async function getAllProducts(): Promise<Product[]> {
  const config = {
    withCredentials: true
  }
  try {
    const response = await axios.get(API_ROOT + '/api/product', config);
    return response.data;
  } catch (error) {
    console.log(error);
    return <any>error;
  }
}

export async function addNewProduct(newProduct: Product): Promise<any> {
  const config = {
    withCredentials: true
  }
  try {
    const response = await axios.post(API_ROOT + '/api/product', newProduct, config);
    return response.data;
  } catch (error) {
    return error;
  }
}