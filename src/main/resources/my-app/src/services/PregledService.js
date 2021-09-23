import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/pregled";

class PregledService {
    getPregledi() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new PregledService();