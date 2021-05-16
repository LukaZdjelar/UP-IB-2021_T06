import axios from 'axios'

const PREGLED_REST_API_URL = "http://localhost:8080/klinickicentar/pregled";

class PregledService {
    getKlinike() {
        return axios.get(PREGLED_REST_API_URL);
    } 
}
export default new PregledService();