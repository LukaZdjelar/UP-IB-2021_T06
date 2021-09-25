import logo from './logo.svg';
import './App.css';
import PacijentComponent from './components/PacijentComponent';
import DoktorComponent from './components/DoktorComponent';
import KlinikaComponent from './components/KlinikaComponent';
// import PregledComponent from './components/PregledComponent';
import SestraComponent from './components/SestraComponent';
import TerminComponent from './components/TerminComponent';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import {NavLink} from "react-router-dom";
import ProfilPacijentaComponent from './components/ProfilPacijentaComponent';
import IsotrijaPregledaComponent from './components/IstorijaPregledaComponent';
import RadniKalendar from './components/sestra/RadniKalendar';
import AdminTable from './components/admin/AdminTable';
import AdminDetails from './components/admin/AdminDetails';
import AdminAboutPage from './pages/AdminAboutPage';
import IzvestajComponent from './components/IzvestajComponent';
import index from './index';
import Login from './pages/Login';
import ReceptComponent from './components/sestra/ReceptComponent';
import SestraProfil from './components/sestra/SestraProfil';
import OdobrenjeRegistrovanihComponent from './components/OdobrenjeRegistrovanihComponent';

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/logovaniPacijent" component = {ProfilPacijentaComponent}/>
          <Route path="/istorijaPregleda" component = {IsotrijaPregledaComponent}/>
          <Route path="/doktor" component = {DoktorComponent} exact/>
          <Route path="/admin" component = {AdminTable} exact/>
          <Route path="/klinika" component = {KlinikaComponent} exact/>
          {/* <Route path="/pregled" component = {PregledComponent} exact/> */}
          <Route path="/sestra" component = {SestraComponent} exact/>
          <Route path="/termin" component = {TerminComponent} exact/>
          <Route path="/pacijent" component = {PacijentComponent} exact/>
          <Route path="/osoblje/radnikalendar" component = {RadniKalendar} exact />
          <Route path="/admin/izvestaj" component = {IzvestajComponent} exact />
          <Route path="/admin/:id" component = {AdminAboutPage} exact/>
          <NavLink activeClassName = "active" to = "/login">Login <small>Acces with token only</small></NavLink>
          </Switch>
          <Route path="/osoblje" component = {SestraProfil} exact/>
          <Route path="/admin/approve" component = {OdobrenjeRegistrovanihComponent} exact/>
          {/* <Route path="/osoblje/:id" component = {SestraAboutPage} exact/> */}
          {/* <Route path="/klinickicentar/recept/overi/:id" component = {receptOvera} exact/> */}
          <Route path="/recepti" component = {ReceptComponent} exact/>
          {/* <Route path="/doktor/pregledi" component = {PregledComponent} exact /> */}
      </div>
      <div className = 'content'>
        <Switch>
          <Route exact path ="/login" component={Login}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
