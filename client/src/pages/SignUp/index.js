import React, { useState } from 'react';
import { PageArea } from './styled';
import useApi from '../../helpers/OlxAPI';
import { doLogin } from '../../helpers/AuthHandler';

import { PageContainer, PageTitle, ErrorMessage } from '../../components/MainComponents'

const Page = () => {
    const api = useApi();

    const [name, setName] = useState('');
    const [nickname, setNickname] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    //disabled quando a pessoa estiver esperando carregar o login, enquanto isso ela não pode preencher o formulário
    const [disabled, setDisabled] = useState(false);
    const [error, setError] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setDisabled(true);
        setError('');

        if(password !== confirmPassword) {
            setError('Senhas não batem');
            setDisabled(false);
            return;
        }

        const json = await api.register(name, nickname, email, password);

        if(json.error) {
            setError(json.error);
        } else {
            //Salva o cookie, carrega toda a página e direciona pro "home"
            doLogin(json.token);
            window.location.href = '/';
        }

        setDisabled(false);
    }

    return (
        <PageContainer>
            <PageTitle>Cadastro</PageTitle>
            <PageArea>
                {error &&
                    <ErrorMessage>{error}</ErrorMessage>
                }

                <form onSubmit={handleSubmit}>
                <label className="area">
                        <div className="area--title">Nome Completo</div>    
                        <div className="area--input">
                            <input 
                                type="text" 
                                disabled={disabled} 
                                value={name}
                                onChange={e=>setName(e.target.value)}
                                required
                            />  
                        </div>    
                    </label>
                    <label className="area">
                        <div className="area--title">Apelido</div>    
                        <div className="area--input">
                            <input 
                                type="text" 
                                disabled={disabled} 
                                value={nickname}
                                onChange={e=>setNickname(e.target.value)}
                                required
                            />  
                        </div>    
                    </label>    
                    <label className="area">
                        <div className="area--title">Email</div>    
                        <div className="area--input">
                            <input 
                                type="email" 
                                disabled={disabled} 
                                value={email}
                                onChange={e=>setEmail(e.target.value)}
                                required
                            />  
                        </div>    
                    </label>  
                    <label className="area">
                        <div className="area--title">Senha</div>    
                        <div className="area--input">
                            <input 
                                type="password" 
                                disabled={disabled} 
                                value={password}
                                onChange={e=>setPassword(e.target.value)}
                                required
                            />  
                        </div>    
                    </label> 

                    <label className="area">
                        <div className="area--title">Confirmar Senha</div>    
                        <div className="area--input">
                            <input 
                                type="password" 
                                disabled={disabled} 
                                value={confirmPassword}
                                onChange={e=>setConfirmPassword(e.target.value)}
                                required
                            />  
                        </div>    
                    </label> 
                   
                    <label className="area">
                        <div className="area--title"></div>    
                        <div className="area--input">
                            <button disabled={disabled}>Fazer Cadastro</button>  
                        </div>    
                    </label>        
                </form>
            </PageArea>
        </PageContainer>
    );
}

export default Page;
