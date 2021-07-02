import axios from 'axios'

const USERS_REST_API_URL = "https://localhost:8080/klinickicentar/pacijent";

class PacijentServis {
    getPacijenti() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new PacijentServis();