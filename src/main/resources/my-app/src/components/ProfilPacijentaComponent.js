import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentService from '../services/PacijentService';
import axios from 'axios';
import PacijentHeader from './PacijentHeader';


class ProfilPacijentaComponent extends React.Component {
    state = {
        ime:"",
        prezime:"",
        email:"",
        adresa:""
    }

    componentDidMount() {
        axios.get("/domZdravlja/pacijentProfil/"+1)
        .then(response => {
            console.log(response);
            this.setState({
                ime:response.data.ime,
                prezime:response.data.prezime,
                email:response.data.email,
                adresa:response.data.adresa
            })
        })
    }
    render(){
        return(
            <div>
                <PacijentHeader />
                <h1>Profil </h1>
                <img src="https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png" width="200px;" height="150px;" alt="profile icon" />
                <div className="ProfilDiv">
                    <p>Ime: {this.state.ime}</p>
                    <p>Prezime: {this.state.prezime}</p>
                    <p>Email: {this.state.email}</p>
                    <p>Broj Telefona: {this.state.adresa}</p>
                </div>  
            </div>
        )
    }
}

export default ProfilPacijentaComponent