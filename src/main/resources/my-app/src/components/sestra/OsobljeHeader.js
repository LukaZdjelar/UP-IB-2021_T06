import React from 'react'
import { Link } from 'react-router-dom';

class OsobljeHeader extends React.Component {
    render() {
        return (
            <div className="header">
                <nav>
                    <Link to="/pacijent">Lista Pacijenata</Link>
                    <Link to="/osoblje/radnikalendar">Radni Kalendar</Link>
                    <Link to="/osoblje/profil">Profil</Link>
                    <Link to="/recepti">Overa Recepta</Link>
                </nav>
            </div>
        )
    }
}
export default OsobljeHeader;