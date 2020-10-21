import React from 'react';
import { Link } from 'react-router-dom';
import { HeaderArea } from './styled';
import  Menubar   from '../Menubar/Menubar';
import logo from './logo_ReGep02.png';
import { isLogged, doLogout } from '../../../helpers/AuthHandler';

const Header = () => {
    let logged = isLogged();

    const handleLogout = () => {
        doLogout();
        window.location.href = '/';
    }

    return (
        <HeaderArea>
            <div className="container">
                <div className="logo">
                    <Link to="/">
                        <img className="logo-1" src={logo} alt="Logo" />
                    </Link>
                </div>
                <nav>
                    <ul>
                        {logged && //Se tiver logado
                            <>
                                <li>
                                    <Link to="/my-account">Minha conta</Link>
                                </li>
                                <li>
                                    <button onClick={handleLogout}>Sair</button>
                                </li>
                                <Menubar />
                            </>
                        } 
                        {!logged && // se não tiver logado
                            <>
                                <li>
                                    <Link to="/signin">Login</Link>
                                </li>
                                <li>
                                    <Link to="/signup">Cadastrar</Link>
                                </li>
                            </>
                        }
                    </ul>
                </nav>
            </div>
        </HeaderArea>
    );
}

export default Header;