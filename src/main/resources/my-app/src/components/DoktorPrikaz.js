import OsobljeService from "../services/OsobljeService";
import OsobljeHeader from "./sestra/OsobljeHeader";
import React from "react";
import PacijentHeader from "./PacijentHeader";

class DoktorPrikaz extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            osoblje:[],
        }
    }

    componentDidMount() {
        let klinikaId = this.props.match.params.klinikaId;
        OsobljeService.getOsobljeByKlinika(klinikaId).then((response) => {
            this.setState({osoblje: response.data})
        });
    }

    render () {
        console.log(this.state.osoblje);
        return (
            <div>
                <div>
                    <PacijentHeader/>
                </div>
                <h1>Lista svih doktora</h1>
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
                            this.state.osoblje.map (
                                osoblje => 
                                <tr key = {osoblje.id}>
                                    <a href={`/termin/${osoblje.id}`}><td>{osoblje.ime}</td></a>
                                    <td>{osoblje.prezime}</td>
                                    <td>{osoblje.email}</td>
                                    <td>{osoblje.brojTelefona}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default DoktorPrikaz;