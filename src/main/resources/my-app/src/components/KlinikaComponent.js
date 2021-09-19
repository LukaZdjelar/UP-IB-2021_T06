import userEvent from '@testing-library/user-event';
import React from 'react'
import KlinikaServis from '../services/KlinikaService';

class KlinikaComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            klinike:[]
        }
    }

    componentDidMount() {
        KlinikaServis.getKlinike().then((response) => {
            this.setState({klinike: response.data})
        });
    }

    render () {
        return (
            <div>
                <h1>Lista svih klinika</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Naziv</td>
                            <td>Opis</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.klinike.map (
                                klinika => 
                                <tr key = {klinika.id}>
                                    <td>{klinika.naziv}</td>
                                    <td>{klinika.opis}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default KlinikaComponent;