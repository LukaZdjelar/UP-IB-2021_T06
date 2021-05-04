import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentService from '../services/PacijentService';

class PacijentComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pacijenti:[]
        }
    }

    componentDidMount() {
        PacijentService.getPacijenti().then((response) => {
            this.setState({pacijenti: response.data})
        });
    }

    render () {
        return (
            <div>
                <h1>Lista svih pacijenata</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Ime</td>
                            <td>Prezime</td>
                            <td>Adresa</td>
                            <td>Br. Telefona</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.pacijenti.map (
                                pacijent => 
                                <tr key = {pacijent.id}>
                                    <td>{pacijent.ime}</td>
                                    <td>{pacijent.prezime}</td>
                                    <td>{pacijent.adresa}</td>
                                    <td>{pacijent.brojTelefona}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default PacijentComponent;