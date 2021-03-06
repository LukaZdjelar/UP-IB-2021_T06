import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { getAccessToken, getRefreshToken, SetAccessToken, SetRefreshToken, removeUserSession , getUserRoles} from '../components/Utils/Common';

function Login (props){

    //const [email,setEmail]= useState('');
    //const [password,setPassword]= useState('');
    const [error,setError]= useState(null);
    const [loading,setLoading]= useState(false);

    const email = useFormInput('');
    const navigateToPropperPage = ()  =>{
        let userRoles  = getUserRoles();

        if(userRoles.includes("ROLE_ADMIN")){
            props.history.push('/admin/approve');
        }else if(userRoles.includes("ROLE_PATIENT")){
            props.history.push('/pacijentProfil')
        }else if(userRoles.includes("ROLE_STAFF")){
            props.history.push('/osoblje')
        }
    }
    useEffect(() =>{
        const token = getAccessToken();
        if(token) {
            navigateToPropperPage()
        } 
    })
    const password = useFormInput('');

    const handleLogin = () =>{
        setError(null);
        setLoading(true);
        axios.post("domZdravlja/auth/login",{
            email:email.value,
            password:password.value
        }).then(response => {

            setLoading(false);
            SetAccessToken(response.data.access_token)
            SetRefreshToken(response.data.refreshToken)
            navigateToPropperPage();
            // props.history.push('/admin');
            console.log('response >>> ', response);
        }).catch(error => {
            setLoading(false);
            if(error?.response?.status === 401 || error?.response?.status === 400){
                setError(error.response.data.message);
            }
            else{
                setError("Something went wrong. Please try again later.");
            }
            // console.log('response >>> ', error.response)
        });
    }


    return(   
    
    <div className='login'> 
        <h2>Login</h2>
        <div className='emailInput'>
            <label>Email</label>
            <input placeholder='Enter your email' type="text" {...email} autoComplete="new-password" />
        </div>
        <div className='passwordInput'>
            <label>Password</label>
            <input  placeholder='Enter your password' type="password" {...password} autoComplete="new-password"/>
        </div>
        <div>
            {error && <div className='error'>{error}</div>}

            <input type="button" id='btnLogin' value={loading ? 'Loading...' : 'Login'} onClick={handleLogin} disabled={loading} />
        </div>

    </div>);
}

const useFormInput = initialValue => {
    const [value, setValue] = useState(initialValue);

    const handleChange = e => {
        setValue(e.target.value);
    }
    return {
        value,
        onChange: handleChange
    }
}

export default Login;