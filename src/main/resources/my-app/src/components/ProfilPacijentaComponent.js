import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentHeader from './PacijentHeader';
import PacijentService from '../services/PacijentService';
import axios from 'axios';



class ProfilPacijentaComponent extends React.Component {
    state = {
        ime:"",
        prezime:"",
        email:"",
        brojTelefona:""
    }

    componentDidMount() {
        axios.get("/domZdravlja/pacijent/"+4)
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
                <div>
                    <PacijentHeader/>
                </div>
                <h1>Profil </h1>
                <img src="https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png" width="200px;" height="150px;" alt="profile icon" />
                <div className="ProfilDiv">
                    <p>Name: {this.state.ime}</p>
                    <p>Prezime: {this.state.prezime}</p>
                    <p>Email: {this.state.email}</p>
                    <p>Broj Telefona: {this.state.brojTelefona}</p>
                </div>  
            </div>
        )
    }
}
export default ProfilPacijentaComponent;