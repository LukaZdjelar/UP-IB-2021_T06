import axios from 'axios';
import React, { useState } from 'react';

const Login = (props) => {


    const [email,setEmail]= useState('');
    const [password,setPassword]= useState('');
    const [error,setError]= useState(null);
    const [loading,setLoading]= useState(false);

    const handleLogin = () =>{
        setError(null);
        setLoading(true);
        axios.post("htpp://localhost:8080/domZdravlja/aou/login",{
            email:email,
            password:password
        }).then(response => {
            setLoading(false);
            setUserSession(response.data.access_token)
            if(response.data.role.includes("ADMIN")){
                props.history.push('/admin');
            }else if(response.data.role.includes("NURSE")){
                props.history.push('/sestra')
            }else if(response.data.role.includes("DOCTOR")){
                props.history.push('/doctor')
            }else if(response.data.role.includes("PATIENT")){
                props.history.push('/pacijent')
            }else if(response.data.role.includes("STAF")){
                props.history.push('/osoblje')
            }
            props.history.push('/admin')
            console.log('response >>> ', response)
        }).catch(error => {
            setLoading(false);
            if(error.response.status === 401 || error.response.status === 400){
                setError(error.response.data.message);
            }
            else{
                setError("Something went wrong. Please try again later.");
            }
            console.log('response >>> ', response)
        })
    }


    <div>
        Login<br/> <br/>
        <div>
            Email<br/>
            <input type='text'
            value={email}
            onChange={e => setEmail(e.target.value)}
            />
        </div>
        <div>
            Password<br/>
            <input type='text'
            value={password}
            onChange={e => setPassword(e.target.value)}
            />
        </div>
        <div>
            {error && <div className='error'>{error}</div>}
            <input type='button'
            value={loading ? "Loading ..." : 'Login'}
            disabled={loading}
            onClick = {handleLogin}
            />
        </div>

    </div>

}

export default Login