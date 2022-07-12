import React from 'react'
import { Link } from 'react-router-dom';
import { isUserLoggedIn } from '../Utils/Common';

class OsobljeHeader extends React.Component {
    render() {

        
     
        return (
            <div className="header">
                <nav>
                    <Link to="/pacijent">Lista Pacijenata</Link>
                    <Link to="/osoblje/radnikalendar">Radni Kalendar</Link>
                    <Link to="/osoblje/">Profil</Link>
                    <Link to="/recepti">Overa Recepta</Link> 
                    {isUserLoggedIn() ? ( <Link to={'/'} onClick={() => localStorage.clear()}>Logout</Link>):""}
                </nav>
            </div>
        )
    }
}
export default OsobljeHeader;