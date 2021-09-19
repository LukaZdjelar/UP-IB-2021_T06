import axios from 'axios'

const USERS_REST_API_URL = "https://localhost:8080/klinickicentar/pregled";

class PregledService {
    getPregledi() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new PregledService();