import React from 'react'
import { Link } from 'react-router-dom';

class OsobljeHeader extends React.Component {
    render() {
        return (
            <div className="header">
                <nav>
                    <Link to="/pacijent">Lista Pacijenata</Link>
                    <Link to="/radnikalendar">Radni Kalendar</Link>
                    <Link to="/klinickicentar/profil">Profil</Link>
                    <Link to="/klinickicentar/overavanjeRecepta">Overa Recepta</Link>
                </nav>
            </div>
        )
    }
}
export default OsobljeHeader;