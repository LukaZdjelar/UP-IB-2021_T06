import React from 'react'
import ReceptService from '../../services/ReceptService';
import { Link } from 'react-router-dom';
import OsobljeHeader from './OsobljeHeader';


const overi = async(id) => {
    await fetch(`https://localhost:8080/klinickicentar/recept/overi/${id}`, {
        method: 'PUT'
    });
}


class ReceptComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            recepti:[]
        }
    }

    componentDidMount() {
        ReceptService.getRecepti().then((response) => {
            this.setState({recepti: response.data})
        });
    }

    render() {
        return (
            <div>
                <OsobljeHeader />
                {
                    this.state.recepti.map (
                    recept =>
                    <div key={recept.id}>
                        <p>Text recepta: <span>{recept.text}</span></p>
                        <p>Status overe:  <span>{recept.overen.toString()}</span></p>
                        <button onClick={() => overi(recept.id)}>Overi recept</button>
                        {/* <Link to={"klinickicentar/recept/overi/" + recept.id}>Overi recept</Link> */}
                    </div>
                )}
            </div>
        )
    }
}

export default ReceptComponent;