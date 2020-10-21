import React from 'react';
import { PageArea } from './styled';
import { PageContainer } from '../../components/MainComponents'

import  TextEditor  from '../../components/partials/RulesEditor/TextEditor'; 

const Rules = () => {

    return (
        <PageContainer>
            <PageArea>
                <h1>Regras</h1>
                <TextEditor />
            </PageArea>
        </PageContainer>
    );
}

export default Rules;
