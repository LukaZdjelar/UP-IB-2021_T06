import userEvent from '@testing-library/user-event';
import React from 'react'
import AdminService from '../services/AdminService';
import KlinikaServis from '../services/KlinikaService';
import OsobljeServis from '../services/OsobljeService';


class IzvestajComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            klinike:[],
            osoblje:[]
        }
    }

    componentDidMount() {
        KlinikaServis.getKlinike().then((response) => {
            this.setState({...this.state, klinike: response.data});
        OsobljeServis.getOsoblje().then((response) =>{
            this.setState({...this.state, osoblje: response.data})
        })
        });
    }

    render () {
        return (
            <div>
                <h1>Prikaz izvestaja</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Doktor</td>
                            <td>Klinika</td>
                            <td>Ocena doktora</td>
                            <td>Ocena klinike</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.klinike.map (
                                klinika => 
                                <tr key = {klinika.id}>
                                    <td>{klinika.naziv}</td>
                                    <td>{average(klinika.ocena)}</td>
                                </tr>
                            )
                        }
                        {
                            this.state.osoblje.map (
                                osoblje => 
                                <tr key = {osoblje.id}>
                                    <td>{osoblje.ime}</td>
                                    <td>{average(osoblje.ocena)}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default IzvestajComponent;