import userEvent from '@testing-library/user-event';
import React from 'react'
import PacijentService from '../services/PacijentService';
import OsobljeHeader from './sestra/OsobljeHeader';

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
        console.log(this.state.pacijenti);
        return (
            <div>
                <div>
                    <OsobljeHeader />
                </div>
                <h1>Lista svih pacijenata</h1>
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