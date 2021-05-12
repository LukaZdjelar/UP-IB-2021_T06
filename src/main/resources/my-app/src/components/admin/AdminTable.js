import React, { Component } from 'react'
import {Link} from "react-router-dom"
import Admin from './Admin'
import axios from 'axios'

class AdminTable extends React.Component{
        state = {
            admini:[]
        }

    componentDidMount() {
        axios.get("http://localhost:8080/klinickicentar/admin").then(response=>{
            this.setState({
                admini:response.data
            })
        })
    }

    render () {
        let admini = <p>Nema admina</p>
        if (this.state.admini.length>0) {
            admini = this.state.admini.map(
                admin => {
                    return(
                        <Admin ime={admin.ime} prezime={admin.prezime} id={admin.id} key={admin.id}/>
                    )
                }
            )
        }
        return (
            <div>
                <h1>Lista svih administratora</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Ime</td>
                            <td>Prezime</td>
                        </tr>
                    </thead>
                    <tbody>
                        {admini}
                    </tbody>
                </table>
            </div>
        )
    }
}
export default AdminTable;