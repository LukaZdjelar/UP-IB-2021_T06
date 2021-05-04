import logo from './logo.svg';
import './App.css';
import PacijentComponent from './components/PacijentComponent';
import DoktorComponent from './components/DoktorComponent';
import AdminComponent from './components/AdminComponent';
import KlinikaComponent from './components/KlinikaComponent';
import PregledComponent from './components/PregledComponent';
import SestraComponent from './components/SestraComponent';
import TerminComponent from './components/TerminComponent';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/doktor" component = {DoktorComponent}/>
          <Route path="/admin" component = {AdminComponent}/>
          <Route path="/klinika" component = {KlinikaComponent}/>
          <Route path="/pregled" component = {PregledComponent}/>
          <Route path="/sestra" component = {SestraComponent}/>
          <Route path="/termin" component = {TerminComponent}/>
          <Route path="/pacijent" component = {PacijentComponent}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
