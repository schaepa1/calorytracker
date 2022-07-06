import axios from 'axios';
import { API_ROOT } from "@/config/development";

export async function getUserDemands(): Promise<any> {
  const config = {
    withCredentials: true
  }
  try {
    const response = await axios.get(API_ROOT + '/api/users', config)
    return response.data;
  } catch (error) {
    return <any>error;
  }
}

export async function saveNewDemands(demands: Object): Promise<any> {
  const config = {
    withCredentials: true
  }
  try {
    await axios.put(API_ROOT + '/api/users', demands, config);
  } catch (error) {
    return error;
  }
}