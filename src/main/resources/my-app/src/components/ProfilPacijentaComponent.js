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

    onTextChange(event) {
        if(event.target.name ==='ime') {
            this.setState({...this.state, ime: event.target.value})
        }
        if(event.target.name === 'prezime') {
            this.setState({...this.state, prezime: event.target.value})
        } else {
            this.setState({...this.state, brojTelefona: event.target.value})
        }
    }
    changeEditMode() {
        this.setState({...this.state, isEditMode: !this.state.isEditMode});
    }
    savePatient(){
        axios.put("/domZdravlja/pacijent/edit",{
            ... this.state.pacijetCopy,
            ime:this.state.ime,
            prezime:this.state.prezime,
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
                    <input value={this.state.ime} name="ime" onChange={this.onTextChange.bind(this)}/>
                    <input value={this.state.prezime} name="prezime" onChange={this.onTextChange.bind(this)}/>
                    <input value={this.state.brojTelefona} name="brojTelefona" onChange={this.onTextChange.bind(this)}/>
                    <button onClick={this.savePatient.bind(this)}>Sacuvaj</button>
                    <button onClick={this.changeEditMode.bind(this)}>Odustani</button>
                    </div>
                    ):(<div>
                         <p>Name: {this.state.pacijetCopy.ime}</p>
                    <p>Prezime: {this.state.pacijetCopy.prezime}</p>
                    <p>Email: {this.state.pacijetCopy.email}</p>
                    <p>Broj Telefona: {this.state.pacijetCopy.brojTelefona}</p>
                    { this.state.loggedUserId === this.state.pacijetCopy?.id ?( <button onClick={this.changeEditMode.bind(this)}>Izmeni</button>):""}
                    </div>)}
                   
                </div>  
            </div>
        )
    }
}
export default ProfilPacijentaComponent;