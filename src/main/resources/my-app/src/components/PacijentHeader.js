import React from 'react'
import { Link } from 'react-router-dom';

class PacijentHeader extends React.Component {
    render() {
        return (
            <div className="header">
                <nav>
                    <Link to="/izmenaProfila">Izmena Profila</Link>
                    <Link to="/istorijaPregleda">Istorija Pregleda</Link>
                    <Link to="/pacijentProfil">Profil</Link>
                </nav>
            </div>
        )
    }
}
export default PacijentHeader;