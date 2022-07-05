import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Product } from '@/model/product';

export async function getAllProducts(): Promise<Product[]> {
  const config = {
    withCredentials: true
  }
  try {
    let newDate = new Date();
    let day = newDate.getDate();
    let dayString = day.toString();
    if(day < 10) {
      dayString = "0" + dayString;
    }
    let month = newDate.getMonth()+1;
    let monthString = month.toString();
    if(month < 10) {
      monthString = "0" + monthString;
    }
    let year = newDate.getFullYear();
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
    console.log("ERSTELLTES PRODUCT", response.data);
    return response.data;
  } catch (error) {
    return error;
  }
}