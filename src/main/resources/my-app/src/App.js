import logo from './logo.svg';
import './App.css';
import PacijentComponent from './components/PacijentComponent';
import DoktorComponent from './components/DoktorComponent';
import KlinikaComponent from './components/KlinikaComponent';
import PregledComponent from './components/PregledComponent';
import SestraComponent from './components/SestraComponent';
import TerminComponent from './components/TerminComponent';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import ProfilPacijentaComponent from './components/ProfilPacijentaComponent';
import IsotrijaPregledaComponent from './components/IstorijaPregledaComponent';
import RadniKalendar from './components/sestra/RadniKalendar';
import AdminTable from './components/admin/AdminTable';
import AdminDetails from './components/admin/AdminDetails';
import AdminAboutPage from './pages/AdminAboutPage';
import IzvestajComponent from './components/IzvestajComponent';
import index from './index';
import Login from './pages/Login';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Switch>
          <Route path="/logovaniPacijent" component = {ProfilPacijentaComponent}/>
          <Route path="/istorijaPregleda" component = {IsotrijaPregledaComponent}/>
          <Route path="/doktor" component = {DoktorComponent} exact/>
          <Route path="/admin" component = {AdminTable} exact/>
          <Route path="/klinika" component = {KlinikaComponent} exact/>
          <Route path="/pregled" component = {PregledComponent} exact/>
          <Route path="/sestra" component = {SestraComponent} exact/>
          <Route path="/termin" component = {TerminComponent} exact/>
          <Route path="/pacijent" component = {PacijentComponent} exact/>
          <Route path="/osoblje/radnikalendar" component = {RadniKalendar} exact />
          <Route path="/admin/izvestaj" component = {IzvestajComponent} exact />
          <Route path="/admin/:id" component = {AdminAboutPage} exact/>
          <NavLink activeClassName = "active" to = "/login">Login <small>Acces with token only</small></NavLink>
          </Switch>
      </div>
      <div className = 'content'>
        <Switch>
          <Route exact path ="/" component={Home}/>
          <Route exact path ="/login" component={Login}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
