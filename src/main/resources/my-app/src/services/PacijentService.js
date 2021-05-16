import axios from 'axios'

const USERS_REST_API_URL = "http://localhost:8080/klinickicentar/pacijent";

class PacijentServis {
    getPacijenti() {
        return axios.get(USERS_REST_API_URL);
    }  
    getPacijentById(id){
        return axios.get(`${USERS_REST_API_URL}/${id}`);
    }
}
export default new PacijentServis();