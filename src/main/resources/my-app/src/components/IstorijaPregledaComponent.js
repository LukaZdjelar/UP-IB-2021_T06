import userEvent from '@testing-library/user-event';
import React from 'react'
import PregledService from '../services/PregledService';
import PacijentHeader from './PacijentHeader';

class PregledComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pregledi:[]
        }
    }

    componentDidMount() {
        PregledService.getPregledi().then((response) => {
            this.setState({pregledi: response.data})
        });
    }

    render () {
        console.log(this.state.pregledi);
        return (
            <div>
                <div>
                    <PacijentHeader/>
                </div>
                <h1>Istorija pregleda</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Termin</td>
                            <td>Opis</td>
                            <td>Trajanje</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.pregledi.map (
                                pregled => 
                                <tr key = {pregled.id}>
                                    <td>{pregled.termin?.datumIVreme}</td>
                                    <td>{pregled.opis}</td>
                                    <td>{pregled.termin?.trajanje} min</td>

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