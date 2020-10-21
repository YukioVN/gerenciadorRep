import React, { Component } from 'react';
import { PageArea } from './styled';
import useApi from '../../helpers/OlxAPI';
import { isLogged } from '../../helpers/AuthHandler';
import { PageContainer } from '../../components/MainComponents'

import 'react-calendar/dist/Calendar.css';
import ReactCalendar from '../../components/partials/Calendar';

const Page = () => {
    const api = useApi();
    let logged = isLogged();

    return (
        <PageContainer>
            <PageArea>
                <h1>Home</h1>
                {logged && <><ReactCalendar /></>}
            </PageArea>
        </PageContainer>
    );
}

export default Page;