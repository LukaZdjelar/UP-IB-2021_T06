import React from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import OsobljeHeader from './OsobljeHeader'
import { getUserId } from '../Utils/Common'


class SestraProfil extends React.Component {

    state = {
        ime:"",
        prezime:"",
        email:"",
        brojTelefona:""
    }

    componentDidMount() {
        const userID = getUserId();
        axios.get("/domZdravlja/osoblje/"+userID)
        .then(response => {
            console.log(response);
            this.setState({
                ime:response.data.ime,
                prezime:response.data.prezime,
                email:response.data.email,
                brojTelefona:response.data.brojTelefona
            })
        })
    }
    render(){
        return(
            <div>
                <OsobljeHeader />
                <h1>Profil </h1>
                <img src="https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png" width="200px;" height="150px;" alt="profile icon" />
                <div className="ProfilDiv">
                    <p>Ime: {this.state.ime}</p>
                    <p>Prezime: {this.state.prezime}</p>
                    <p>Email: {this.state.email}</p>
                    <p>Broj Telefona: {this.state.brojTelefona}</p>
                </div>  
            </div>
        )
    }
}

export default SestraProfil