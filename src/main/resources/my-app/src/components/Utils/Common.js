export const getUser = () => {
    const userStr = sessionStorage.getItem("user");
    if(userStr) return JSON.parse(userStr);
    else return null;
}

export const getToken = () => {
    return sessionStorage.getItem("token") || null;
}

export const getUserSession = (token,user) => {
    sessionStorage.getItem('token',token);
    sessionStorage.setItem('user',JSON.stringify(user));

}

export const removeUserSession = () => {
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("user");
}