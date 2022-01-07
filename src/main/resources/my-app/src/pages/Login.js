import axios from 'axios';
import React, { useState } from 'react';
import { getAccessToken, getRefreshToken, SetAccessToken, SetRefreshToken, removeUserSession , getUserRoles} from '../components/Utils/Common';

function Login (props){

    //const [email,setEmail]= useState('');
    //const [password,setPassword]= useState('');
    const [error,setError]= useState(null);
    const [loading,setLoading]= useState(false);

    const email = useFormInput('');
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
            let userRoles  = getUserRoles("ADMIN");

            if(userRoles.includes("ROLE_ADMIN")){
                props.history.push('/admin/approve');
            }else if(userRoles.includes("ROLE_NURSE")){
                props.history.push('/sestra')
            }else if(userRoles.includes("ROLE_DOCTOR")){
                props.history.push('/doctor')
            }else if(userRoles.includes("ROLE_PATIENT")){
                props.history.push('/pacijent')
            }else if(userRoles.includes("ROLE_STAFF")){
                props.history.push('/osoblje')
            }
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


    return(        <div>
        Login<br/> <br/>
        <div>
            <label>Email</label>
            <input type="text" {...email} autoComplete="new-password" />
        </div>
        <div>
            <label>Password</label>
            <input type="password" {...password} autoComplete="new-password"/>
        </div>
        <div>
            {error && <div className='error'>{error}</div>}

            <input type="button" value={loading ? 'Loading...' : 'Login'} onClick={handleLogin} disabled={loading} /><br />
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