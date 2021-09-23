import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/recept";

class ReceptService {
    getRecepti() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new ReceptService();