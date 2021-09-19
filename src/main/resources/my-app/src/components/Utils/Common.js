import jwtDecode from 'jwt-decode'

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