import React, { Component } from 'react'
import {Link} from "react-router-dom"

const admin = props =>{
    return(
        <tr key = {props.id} id = {props.id}>
            <td><Link to={'/admin/about/'+props.id}>{props.ime}</Link></td>
            <td>{props.prezime}</td>
        </tr>
    )
}
export default admin;