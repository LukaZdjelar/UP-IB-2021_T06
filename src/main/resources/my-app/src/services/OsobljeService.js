import axios from 'axios'

const USERS_REST_API_URL = "http://localhost:8080/klinickicentar/osoblje";

class OsobljeService {
    getOsoblje() {
        return axios.get(USERS_REST_API_URL);
    }  
    getOsobljeById(id){
        return axios.get(`${USERS_REST_API_URL}/${id}`);
    }
}
export default new OsobljeService();