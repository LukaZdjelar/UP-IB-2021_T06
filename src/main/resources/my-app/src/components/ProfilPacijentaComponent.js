import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentHeader from './PacijentHeader';
import PacijentService from '../services/PacijentService';
import axios from 'axios';
import {getUserId} from './Utils/Common';



class ProfilPacijentaComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ime:"",
            prezime:"",
            email:"",
            brojTelefona:"",
            pacijetCopy:{},
            isEditMode: false,
            loggedUserId: null
        }
    }
   

    componentDidMount() {
        let userId = getUserId();
        axios.get(`/domZdravlja/pacijent/${userId}`)
        .then(response => {
            console.log(response);
            this.setState({
                ime:response.data.ime,
                prezime:response.data.prezime,
                email:response.data.email,
                brojTelefona:response.data.brojTelefona,
                pacijetCopy: response.data,
                loggedUserId: userId
            })
        })
    }

    changeEditMode() {
        this.setState({...this.state, isEditMode: !this.state.isEditMode});
    }

    savePatient(){
        axios.post("/domZdravlja/pacijent",{
            ime:this.state.ime,
             prezime:this.state.prezime,
                email:this.state.email,
                brojTelefona:this.state.brojTelefona
        })
        .then(response => {
            console.log(response);
            this.setState({
                ime:response.data.ime,
                prezime:response.data.prezime,
                email:response.data.email,
                brojTelefona:response.data.brojTelefona,
                pacijetCopy: response.data,
                isEditMode: false
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
                    {this.state.isEditMode ? (
                        <div>
                    <input value={this.state.ime} name="ime"/>
                    <input value={this.state.prezime} name="prezime"/>
                    <input value={this.state.brojTelefona} name="brojTelefona"/>
                    <button onClick={this.savePatient}>Sacuvaj</button>
                    <button onClick={this.changeEditMode}>Odustani</button>
                    </div>
                    ):(<div>
                         <p>Name: {this.state.pacijetCopy.ime}</p>
                    <p>Prezime: {this.state.pacijetCopy.prezime}</p>
                    <p>Email: {this.state.pacijetCopy.email}</p>
                    <p>Broj Telefona: {this.state.pacijetCopy.brojTelefona}</p>
                    { this.state.loggedUserId === this.state.pacijetCopy?.id ?( <button onClick={this.changeEditMode}>Izmeni</button>):""}
                    </div>)}
                   
                </div>  
            </div>
        )
    }
}
export default ProfilPacijentaComponent;