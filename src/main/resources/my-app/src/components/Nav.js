import React, {Component} from "react";
import { Link } from "react-router-dom";

export default class Nav extends Component{
    render(){

        let buttons;

        if(this.props.user){

            buttons = (<ul className="navbar-nav ml-auto>">
                <li className="nav-item">
                    <Link to={'/'} onClick={() => localStorage.clear}>Login</Link>
                </li>
            </ul>)

        }else{
            buttons = (<ul className="navbar-nav ml-auto>">
                <li className="nav-item">
                    <Link to={'/'} className='nav-link'>Login</Link>
                </li>
            </ul>)


        return(
            <nav className="navbar navbar-expand navbar-light fixed-top">
                <div className="container">
                    <Link className="navbar-brand" to={'/'}>Home</Link>
                    <div className="collapse navbar-collapse">
                        {buttons}
                    </div>
                </div>
            </nav>
        )
        }
    }
}