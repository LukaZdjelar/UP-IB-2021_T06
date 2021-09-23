import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/pacijent";

class PacijentServis {
    getPacijenti() {
        return axios.get(USERS_REST_API_URL);
    }  
    getPacijentById(id){
        return axios.get(`${USERS_REST_API_URL}/${id}`);
    } 
    getUnapprovedPacijenti() {
        return axios.get(USERS_REST_API_URL + "/waitingapproval");
    }
}
export default new PacijentServis();