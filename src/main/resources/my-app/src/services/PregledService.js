import axios from 'axios'

const USERS_REST_API_URL = "https://localhost:8080/klinickicentar/domZdravlja/pregled";

class PregledService {
    getPregledi() {
        return axios.get(USERS_REST_API_URL);
    } 
    
    savePregled(id) {
        return axios.post(`${USERS_REST_API_URL}/${id}`,)
    }
}
export default new PregledService();