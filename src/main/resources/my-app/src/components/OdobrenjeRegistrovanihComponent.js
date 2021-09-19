import React from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import OsobljeHeader from './sestra/OsobljeHeader'
import PacijentService from '../services/PacijentService';

const odobri = async(id) => {
    console.log(id);
    await fetch(`https://localhost:8080/klinickicentar/pacijent/approve/${id}`, {
        method: 'PUT'
    });
}

class OdobrenjeRegistrovanihComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pacijenti:[]
        }
    }

    componentDidMount() {
        PacijentService.getUnapprovedPacijenti().then((response) => {
            this.setState({pacijenti: response.data})
        });
    }
    render () {
        return (
            <div>
                <div>
                    <OsobljeHeader />
                </div>
                <h1>Lista Svih Novoregistrovanih Korisnika</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Email</th>
                            <th>Br. Telefona</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.pacijenti.map (
                                pacijent => 
                                <tr key = {pacijent.id}>
                                    <td>{pacijent.ime}</td>
                                    <td>{pacijent.prezime}</td>
                                    <td>{pacijent.email}</td>
                                    <td>{pacijent.brojTelefona}</td>
                                    <button onClick={() => odobri(pacijent.id)}>Odobri Registraciju</button>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default OdobrenjeRegistrovanihComponent