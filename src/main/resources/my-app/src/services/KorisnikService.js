import axios from 'axios'

const USERS_REST_API_URL = "/domZdravlja/index";

class KorisnikService{
    getKorisnik(password,email){
        return axios.get(`${USERS_REST_API_URL}/${password,email}`);
    }
}
export default new KorisnikService();