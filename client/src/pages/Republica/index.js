import React, { useState } from 'react';
import { PageArea } from './styled';

import { PageContainer } from '../../components/MainComponents'

const Republica = () => {
    const [houseName, setHouseName] = useState('');
    const [responsibleName, setResponsibleName] = useState('');

    return (
        <PageContainer>
            <PageArea>
                <h1>Cadastrar Republica</h1>
                <form>
                    <label className="area">
                        <div className="area--title">Nome da República</div>    
                        <div className="area--input">
                            <input 
                                type="text" 
                                value={houseName}
                                required
                            />  
                        </div>    
                    </label>  
                    <label className="area">
                        <div className="area--title">Morador Responsável</div>    
                        <div className="area--input">
                            <input 
                                type="text" 
                                value={responsibleName}
                                required
                            />  
                        </div>    
                    </label>  
                    <label className="area">
                        <div className="area--title"></div>    
                        <div className="area--input">
                            <button>Cadastrar República</button>  
                        </div>    
                    </label>        
                </form>
            </PageArea>
        </PageContainer>
    );
}

export default Republica;
