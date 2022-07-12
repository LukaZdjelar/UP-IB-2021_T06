import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/osoblje";

class OsobljeService {
    getOsoblje() {
        return axios.get(USERS_REST_API_URL);
    }  
    getOsobljeById(id){
        return axios.get(`${USERS_REST_API_URL}/${id}`);
    }

    getOsobljeByKlinika(klinikaId){
        return axios.get(`${USERS_REST_API_URL}/klinika/${klinikaId}`)
    }
}
export default new OsobljeService();