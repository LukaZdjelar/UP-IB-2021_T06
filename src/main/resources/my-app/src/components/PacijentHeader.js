import React from 'react'
import { Link } from 'react-router-dom';
import { isUserLoggedIn } from './Utils/Common';

class PacijentHeader extends React.Component {
    render() {
        return (
            <div className="header">
                <nav>
                    <Link to="/pacijentProfil">Profil</Link>
                    <Link to="/klinika">Prikaz klinika</Link>
                    <Link to="/pregled">Istorija pregleda</Link>
                    {isUserLoggedIn() ? ( <Link to={'/'} onClick={() => localStorage.clear()}>Logout</Link>):""}
                </nav>
            </div>
        )
    }
}
export default PacijentHeader;