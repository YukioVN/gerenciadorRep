import React from 'react';
import { Switch, Route } from 'react-router-dom';

import Home from './pages/Home';
import About from './pages/About';
import NotFound from './pages/NotFound';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import Events from './pages/Events';
import Expenses from './pages/Expenses';
import Ranking from './pages/Ranking';
import Tasks from './pages/Tasks';
import Republica from './pages/Republica'; 
import Rules from './pages/Rules';

export default () => {
    return (
        //Vai de uma tela a outra
        <Switch>
            <Route exact path="/">
                <Home />
            </Route>
            <Route exact path="/about">
                <About />
            </Route>
            <Route exact path="/Republica">
                <Republica />
            </Route>
            <Route exact path="/signin">
                <SignIn />
            </Route>
            <Route exact path="/signup">
                <SignUp />
            </Route>
            <Route exact path="/Events">
                <Events />
            </Route>
            <Route exact path="/Expenses">
                <Expenses />
            </Route>
            <Route exact path="/Ranking">
                <Ranking />
            </Route>
            <Route exact path="/Tasks">
                <Tasks />
            </Route>
            <Route exact path="/Rules">
                <Rules />
            </Route>
            <Route>
                <NotFound />
            </Route>
        </Switch>
    );
}