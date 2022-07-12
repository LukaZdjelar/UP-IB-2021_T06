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
import { useState } from 'react';
import ProtectedRoutes from './components/ProtectedRoutes';
import Login from './pages/Login';
import ReceptComponent from './components/sestra/ReceptComponent';
import SestraProfil from './components/sestra/SestraProfil';
import OdobrenjeRegistrovanihComponent from './components/OdobrenjeRegistrovanihComponent';
import DoktorPrikaz from './components/DoktorPrikaz';


function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <ProtectedRoutes path="/logovaniPacijent" component = {ProfilPacijentaComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_PATIENT"]}/>
          <ProtectedRoutes path="/istorijaPregleda" component = {IsotrijaPregledaComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]} />
          <ProtectedRoutes path="/doktor" component = {DoktorComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          <ProtectedRoutes path="/admin" component = {AdminTable} exact expectedRoles ={["ROLE_ADMIN"]}/>
          <ProtectedRoutes path="/klinika" component = {KlinikaComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_PATIENT","ROLE_STAFF"]}/>
          {/* <Route path="/pregled" component = {PregledComponent} exact/> */}
          <ProtectedRoutes path="/doktor/:klinikaId" component = {DoktorPrikaz} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          <ProtectedRoutes path="/sestra" component = {SestraComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          <ProtectedRoutes path="/termin/:doktorId" component = {TerminComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF","ROLE_PATIENT"]}/>
          <ProtectedRoutes path="/pacijent" component = {PacijentComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF","ROLE_PATIENT"]}/>
          <ProtectedRoutes path="/pacijentProfil" component = {ProfilPacijentaComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF","ROLE_PATIENT"]}/>
          <ProtectedRoutes path="/osoblje/radnikalendar" component = {RadniKalendar} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]} />
          <ProtectedRoutes path="/admin/izvestaj" component = {IzvestajComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]} />
          <ProtectedRoutes path="/admin/:id" component = {AdminAboutPage} exact expectedRoles ={["ROLE_ADMIN"]}/>
          <ProtectedRoutes path="/pregled" component = {IsotrijaPregledaComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          </Switch>
          <ProtectedRoutes path="/osoblje" component = {SestraProfil} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          <ProtectedRoutes path="/admin/approve" component = {OdobrenjeRegistrovanihComponent} exact expectedRoles ={["ROLE_ADMIN"]}/>
          {/* <Route path="/osoblje/:id" component = {SestraAboutPage} exact/> */}
          {/* <Route path="/klinickicentar/recept/overi/:id" component = {receptOvera} exact/> */}
          <ProtectedRoutes path="/recepti" component = {ReceptComponent} exact expectedRoles ={["ROLE_ADMIN","ROLE_STAFF"]}/>
          {/* <Route path="/doktor/pregledi" component = {PregledComponent} exact /> */}
      </div>
      <div className = 'content'>
        <Switch>
          <Route exact path ="/" component={Login}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
