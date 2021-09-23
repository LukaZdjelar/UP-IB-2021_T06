import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/termin";

class TerminService {
    getTermini() {
        return axios.get(USERS_REST_API_URL);
    }  
}
export default new TerminService();