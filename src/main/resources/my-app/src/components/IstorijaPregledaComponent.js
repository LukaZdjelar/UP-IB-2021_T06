import userEvent from '@testing-library/user-event';
import React from 'react'
import PregledService from '../services/PregledService';

class PregledComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pregled:[]
        }
    }

    componentDidMount() {
        PregledService.getPregled().then((response) => {
            this.setState({pregled: response.data})
        });
    }

    render () {
        return (
            <div>
                <h1>Istorija pregleda</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Termin</td>
                            <td>Opis</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.pregldedi.map (
                                pregled => 
                                <tr key = {pregled.id}>
                                    <td>{pregled.termin}</td>
                                    <td>{pregled.opis}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default PregledComponent;