import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; 
import './Calendar.css';
import { PageContainer } from '../../MainComponents';

const ReactCalendar = () => { 
  const[date, setDate] = useState(new Date());
 
  const onChange = date => {
      setDate(date);
  }
 

    return (
      <>
        <PageContainer>
            <Calendar className="calendar" onChange={onChange} value={date}/>
        </PageContainer>
      </>
    );
  
}
export default ReactCalendar;