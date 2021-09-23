import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import axios from 'axios';
import { getAccessToken,refreshToken} from '../src/components/Utils/Common';

axios.defaults.baseURL = 'https://localhost:8080/klinickicentar/';

axios.defaults.withCredentials = true;

axios.interceptors.request.use(function(config){
    let token = getAccessToken();
    if(token) {
        config.headers = {
            'Authorization' : `Bearer ${token}`
        }
    }
    return config;
},
function(error) {
    return Promise.reject(error);
})

axios.interceptors.response.use(function(response) {
  return response;
}, async function(err){
   const originalRequest = err.config;
   if(err.response?.status == 401 ){
       await refreshToken();
       let token = getAccessToken();
       originalRequest.headers['Authorization'] = 'Bearer' + token;
       return axios(originalRequest);
   }
   return Promise.reject(err.response);
})


ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
