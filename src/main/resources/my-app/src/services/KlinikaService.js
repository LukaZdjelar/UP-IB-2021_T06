import axios from 'axios'

const KLINIKA_REST_API_URL = "/domZdravlja/klinika";

class KlinikaServis {
    getKlinike() {
        return axios.get(KLINIKA_REST_API_URL);
    } 
}
export default new KlinikaServis();