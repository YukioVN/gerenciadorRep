import React, { useState } from 'react';
import { PageArea } from './styled';
import useApi from '../../helpers/OlxAPI';

import { PageContainer } from '../../components/MainComponents'

const Ranking = () => {
    const api = useApi();

    return (
        <PageContainer>
            <PageArea>
                <h1>Ranking</h1>
            </PageArea>
        </PageContainer>
    );
}

export default Ranking;
