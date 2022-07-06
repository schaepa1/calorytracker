import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Product } from '@/model/product';

export async function getAllProducts(date: Date): Promise<Product[]> {
  const config = {
    withCredentials: true
  }
  try {
    let day = date.getDate();
    let dayString = day.toString();
    if(day < 10) {
      dayString = "0" + dayString;
    }
    let month = date.getMonth()+1;
    let monthString = month.toString();
    if(month < 10) {
      monthString = "0" + monthString;
    }
    let year = date.getFullYear();
    let todayDate = dayString + "." + monthString + "." + year;
    const response = await axios.get(API_ROOT + '/api/product/' + todayDate, config);
    console.log("RESPONSE IST: ", response.data);
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

export async function deleteProductWithID(id: number): Promise<any> {
  const config = {
    withCredentials: true
  }
  try {
    await axios.delete(API_ROOT + '/api/product/' + id, config);
  } catch (error) {
    return error;
  }
}

