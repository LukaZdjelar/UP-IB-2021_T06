import React from 'react';
import ReactDOM  from 'react-dom';
import App from '../App';
import { getAccessToken} from '../components/Utils/Common';


axios.defaults.baseURL = 'https://localhost:8080/';

axios.defaults.withCredentials = true;

axios.interceptors.request.use(function(config){
    let token = getAccessToken();
    if(token) {
        config.headers = {
            'Authorization' : `Bearer ${token}`,
            'Access-Control-Allow-Origin': '*'
        }
    }else{
        config.headers = {
            'Access-Control-Allow-Origin': '*'
        }
    }
    return config;
},
function(error) {
    
    return Promise.reject(error);
})


ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>,
    document.getElementById('root')
);
