
// Srediti kasnije 

import { Calendar, momentLocalizer } from 'react-big-calendar'
import moment from 'moment'
import React from 'react'
import TerminService from '../../services/TerminService'
import "react-big-calendar/lib/css/react-big-calendar.css";
import PregledService from '../../services/PregledService';
import SestraComponent from '../SestraComponent';
import OsobljeHeader from '../sestra/OsobljeHeader';

const localizer = momentLocalizer(moment)


class RadniKalendar extends React.Component {
  state = {
      pregledi:[]
  }

  componentDidMount() {
    PregledService.getPregledi().then((response) => {
      this.setState({pregledi: response.data})
    });
  }
  render() {
    const eventList = [];
    this.state.pregledi.forEach((pregled) => {
      console.log(pregled.termin.datumIVreme);
      let start = moment(pregled.termin.datumIVreme).toDate();
      let end = moment(start).add(pregled.termin.trajanje, 'minutes').toDate();
      eventList.push({id: pregled.id, title: pregled.opis, start: start, end: end, type: pregled, allDay: false}); 
    });
    return (
      <div className="App">
        <OsobljeHeader />
        <Calendar
          localizer={localizer}
          defaultDate={moment().toDate()}
          defaultView="month"
          startAccessor = "start"
          endAccessor = "end"
          events={eventList}
          eventPropGetter={event => {
            const eventData = eventList.find(ot => ot.id === event.id);
            return eventData;
          }}
          style={{ height: "80vh" }}
        />
      </div>
    );
  }
}
//     constructor(props) {
//         super(props);
//         this.state = {
//             termini:[]
//         }
//     }

//     componentDidMount() {
//         TerminService.getTermini().then((response) => {
//             this.setState({termini: response.data})
//         });
//     }
//     render() {
//         return (MyCalendar());
//     }
// }

// const MyCalendar = props => (
//   <div>
//     <p>Lavor</p>
//     <Calendar
//       localizer={localizer}
//       events={eventList}
//       startAccessor="start"
//       endAccessor="end"
//       style={{ height: 500 }}
//     />
//   </div>
// )
export default RadniKalendar;