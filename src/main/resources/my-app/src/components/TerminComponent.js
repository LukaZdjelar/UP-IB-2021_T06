import TerminService from "../services/TerminService";
import axios from "axios";
import React from "react";
import PacijentHeader from "./PacijentHeader";

class TerminComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            termin:[]
        }
    }

    componentDidMount() {
        let doktorId = this.props.match.params.doktorId;
        TerminService.getTerminiByDoktor(doktorId).then((response) => {
            this.setState({termin: response.data})
        });
    }

    zakaziPregled(termin){
        

    }

    render () {
        console.log(this.termin.osoblje);
        return (
            <div>
                <div>
                    <PacijentHeader/>
                </div>
                <h1>Lista svih termina</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Datum i vreme</th>
                            <th>Cena</th>
                            <th>Trajanje termina</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.termin.map (
                                termin => 
                                <tr key = {termin.id}>
                                    <td>{termin.datumivreme}</td>
                                    <td>{termin.cena}</td>
                                    <td>{termin.trajanje}</td>
                                    <button onClick={this.zakaziPregled(termin)}>Zakazi pregled</button>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default TerminComponent;