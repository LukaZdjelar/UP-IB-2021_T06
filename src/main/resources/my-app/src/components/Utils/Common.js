import jwtDecode from 'jwt-decode';
import axios from 'axios';

export const getUser = () => {
    const userStr = sessionStorage.getItem("user");
    if(userStr) return JSON.parse(userStr);
    else return null;
}

export const getAccessToken = () => {
    return localStorage.getItem("accessToken") || null;
}

export const getRefreshToken = () => {
    return localStorage.getItem("refreshToken") || null;
}


export const SetAccessToken = (accessToken) =>{
    localStorage.setItem('accessToken',accessToken);
}

export const SetRefreshToken = (refreshToken) =>{
    localStorage.setItem('refreshToken',refreshToken);
}
export const removeUserSession = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
}

export const getUserRoles = () => {
    const token = localStorage.getItem("accessToken");

    var decoded = jwtDecode(token);
    if(decoded) {
        return decoded.roles?.map(r => r?.authority)
    }
    return [];
}

export const getUserId = () => {
    const token = localStorage.getItem("accessToken");

    var decoded = jwtDecode(token);
    if(decoded) {
        return decoded.userId
    }
    return 0;
}

export const refreshToken = async() => {
    const rt = localStorage.getItem("refreshToken");
    axios.post("/domZdravlja/auth/refreshToken",{"refreshToken":rt}).then(res =>{
        let at = res.data?.access_token;
        let nrt = res.data?.refreshToken;
        SetAccessToken(at);
        SetRefreshToken(nrt);
    })
}