import React from "react";
import { Route, Redirect } from "react-router-dom";
import { hasUserPermission } from "./Utils/Common";

function ProtectedRoutes({expectedRoles : expectedRoles, component: Component, ...rest}){

    return (
        <Route 
        {...rest} 
        render = {(props) =>{
        if(expectedRoles?.length  && hasUserPermission(expectedRoles)){
            return <Component />
        } else {
            return<Redirect to={{pathname: '/', state : { from: props.location } }} />;
        }
    }}/>
    );
}

export default ProtectedRoutes