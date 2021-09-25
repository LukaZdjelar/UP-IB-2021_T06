import axios from 'axios'

const USERS_REST_API_URL = "https://localhost:8080/klinickicentar/domZdravlja/pregled";

class PregledService {
    getPregledi() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new PregledService();