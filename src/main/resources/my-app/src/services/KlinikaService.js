import axios from 'axios'

const KLINIKA_REST_API_URL = "http://localhost:8080/klinickicentar/klinika";

class KlinikaServis {
    getKlinike() {
        return axios.get(KLINIKA_REST_API_URL);
    } 
}
export default new KlinikaServis();