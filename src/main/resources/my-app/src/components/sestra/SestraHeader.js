import React from 'react'
import { Link } from 'react-router-dom';

class SestraHeader extends React.Component {
    render() {
        return (
            <div>
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
export default SestraHeader;