import logo from './logo.svg';
import './App.css';
import PacijentComponent from './components/PacijentComponent';
import DoktorComponent from './components/DoktorComponent';
import AdminComponent from './components/AdminComponent';
import KlinikaComponent from './components/KlinikaComponent';
import PregledComponent from './components/PregledComponent';
import SestraComponent from './components/SestraComponent';
import TerminComponent from './components/TerminComponent';
import RadniKalendar from './components/sestra/RadniKalendar';
import { BrowserRouter, Route } from 'react-router-dom';
import AdminTable from './components/admin/AdminTable';
import AdminDetails from './components/admin/AdminDetails';
import AdminAboutPage from './pages/AdminAboutPage';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
          <Route path="/doktor" component = {DoktorComponent} exact/>
          <Route path="/admin" component = {AdminTable} exact/>
          <Route path="/klinika" component = {KlinikaComponent} exact/>
          <Route path="/pregled" component = {PregledComponent} exact/>
          <Route path="/sestra" component = {SestraComponent} exact/>
          <Route path="/termin" component = {TerminComponent} exact/>
          <Route path="/pacijent" component = {PacijentComponent} exact/>
          <Route path="/admin/:id" component = {AdminAboutPage} exact/>
      </div>
    </BrowserRouter>
  );
}

export default App;
