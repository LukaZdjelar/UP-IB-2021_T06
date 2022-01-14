import userEvent from '@testing-library/user-event';
import React from 'react'
import KlinikaServis from '../services/KlinikaService';
import axios from 'axios';

class KlinikaComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            klinike:[],
            pocetniDatum:null,
            krajnjiDatum:null,
            lokacija:"",
            ocena:0
        }
    }

    handleChange (event) {
        if (event.target.name == "pocetniDatum"){
            this.setState({pocetniDatum:event.target.value})
        }else if(event.target.name == "krajnjiDatum"){
            this.setState({krajnjiDatum:event.target.value})
        }else if(event.target.name == "lokacija"){
            this.setState({lokacija:event.target.value})
        }else if(event.target.name == "ocena"){
            this.setState({ocena:event.target.value})
        }
    }

    componentDidMount() {
        KlinikaServis.getKlinike().then((response) => {
            this.setState({klinike: response.data})
        });
    }

    submitSearch(){
        axios.get(`domZdravlja/klinika/${this.state.pocetniDatum}/${this.state.krajnjiDatum}/${this.state.lokacija}/${this.state.ocena}`).then(response=>{
            this.setState({klinike: response.data});
        })
    }

    render () {
        return (
            <div>
                <tr>Sortiranje</tr>
                <tr>Pocetni datum:</tr>
                <input type = "date" name= "pocetniDatum" onChange ={this.handleChange} />
                <tr>Krajnji datum:</tr>
                <input type = "date" name= "krajnjiDatum" onChange ={this.handleChange}/>
                <tr>Lokacija:</tr>
                <input type = "text" name="lokacija" onChange ={this.handleChange}/>
                <tr>Ocena:</tr>
                <input type = "number" min="1" max="5" name ="ocena" onChange ={this.handleChange}/>
                <button onClick={this.submitSearch}>Pretrazi</button>
                <h1>Lista svih klinika</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Naziv</td>
                            <td>Opis</td>
                            <td>Ocena</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.klinike.map (
                                klinika => 
                                <tr key = {klinika.id}>
                                    <td>{klinika.naziv}</td>
                                    <td>{klinika.opis}</td>
                                    <td>{klinika.ocena}</td>
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