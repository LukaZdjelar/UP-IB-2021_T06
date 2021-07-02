import axios from 'axios'

const USERS_REST_API_URL = "http://localhost:8080/klinickicentar/admin";

class AdminService {
    getAdmin() {
        return axios.get(USERS_REST_API_URL);
    }  
    getAdminById(id){
        return axios.get(`${USERS_REST_API_URL}/${id}`);
    }
    getOsobljeOcena(ocena){
        return axios.get(`${USERS_REST_API_URL}/${ocena}`);
    }
    getKlinikaOcena(ocena){
        return axios.get(`${USERS_REST_API_URL}/${ocena}`)
    }
}
export default new AdminService();