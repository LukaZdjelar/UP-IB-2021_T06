import axios from 'axios'

const USERS_REST_API_URL = "https://localhost:8080/klinickicentar/recept";

class ReceptService {
    getRecepti() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new ReceptService();