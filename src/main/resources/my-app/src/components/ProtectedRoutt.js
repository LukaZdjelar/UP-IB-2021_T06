/*import React from "react";

import {Navigate, Outlet} from "react-router-dom";

{auth:true/false, role:'ROLE_ADMIN'}

const useAuth =() => {
    const user = localStorage.getItem("user")
    if(user){
        return {
            auth: true,
            role:user.role
        }
    }else{
        return{
            auth:false,
            role:null
        }
    }
}

type ProtectedRouteType = {
    roleRequired?:'ROLE_ADMIN'|'ROLE_NURSE'
}

const ProtectedRoutt =(props: ProtectedRouteType) => {
    const {auth,role} = useAuth()
    return auth ? <Outlet /> : <Navigate to="/login"/>
}

export default ProtectedRoutt*/