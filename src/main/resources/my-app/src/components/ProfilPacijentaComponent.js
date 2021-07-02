import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentService from '../services/PacijentService';

class ProfilPacijentaComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ulogovanPacijent:{}
        }
    }

    componentDidMount() {
        PacijentService.getPacijentById(3).then((response) => {
            this.setState({ulogovanPacijent: response.data})
        });
    }

    render () {
        return (
            <div>
                <h1>Prikaz pacijenta: {this.state.ulogovanPacijent.ime}</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Ime</td>
                            <td>Prezime</td>
                            <td>Email</td>
                            <td>Br. Telefona</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td>{this.state.ulogovanPacijent.ime}</td>
                        <td>{this.state.ulogovanPacijent.prezime}</td>
                        <td>{this.state.ulogovanPacijent.Email}</td>
                        <td>{this.state.ulogovanPacijent.brojTelefona}</td></tr>
                    </tbody>
                    <a href = "/prikazKlinika">Prikaz klinika</a>
                    <a href = "/IsotrijaPregledaComponent">Istorija pregleda</a>
                </table>
            </div>
        )
    }
}
export default ProfilPacijentaComponent;