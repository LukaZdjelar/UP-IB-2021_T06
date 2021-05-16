import React from 'react'
import axios from 'axios'
import {withRouter} from 'react-router'

class AdminDetails extends React.Component{

    state = {
        id:null, 
        ime:'',
        prezime:''
    }

    componentDidMount() {
        axios.get("http://localhost:8080/klinickicentar/admin/"+this.props.match.params.id)
        .then(response => {
            this.setState({
                id:response.data.id,
                ime:response.data.ime,
                prezime:response.data.prezime
            })
        })
    }

    render(){
        return(
            <div>
                <p>{this.state.id}</p>
                <p>{this.state.ime}</p>
                <p>{this.state.prezime}</p>
                
            </div>
        )
    }

}
export default withRouter(AdminDetails);