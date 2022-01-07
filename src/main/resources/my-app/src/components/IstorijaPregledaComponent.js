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

    
    render(){
        console.log(this.state.pregledi);
        return(
            <div>
                <PacijentHeader /> 
                <table>
                    <thead>
                        <tr>
                            <td>Termin</td>
                            <td>Opis</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.pregledi.map (
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