import React, { useState, useEffect } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; 
import './Calendar.css';
import moment from 'moment';
import { PageContainer } from '../../MainComponents';

const ReactCalendar = () => { 
  const[date, setDate] = useState(new Date());
 
  const onChange = date => {
      setDate(date);
  }

  useEffect(() => {
    fetch("http://localhost:8080/republica/1/acoes-do-dia/?data="+moment(date).format("yyyy-MM-DD")).then((json) => console.log(json.body));
  },[date]);
 

    return (
      <>
        <PageContainer>
            <Calendar className="calendar" onChange={onChange} value={date}/>
        </PageContainer>
      </>
    );
  
}
export default ReactCalendar;