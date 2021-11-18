import React from 'react';
import {BrowserRouter,Route, Switch} from 'react-router-dom';
import CadastrarDoacao from './pages/CadastrarDoacao';
import CadastrarUser from './pages/CadastrarUser';
import Doacoes from './pages/Doacoes';
import Login from './pages/Login';
import PorqueDoar from './pages/PorqueDoar'
import UpdateUser from './pages/UpadateUser';


export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component = {Login}/>
                <Route path="/porqueDoar" exact component  = {PorqueDoar}/>
                <Route path="/auth/singup"  exact component = {CadastrarUser}/>
                <Route path="/doacoes" exact component = {Doacoes}/>
                <Route path="/cadastrarDoacao" exact component = {CadastrarDoacao}/>
                <Route path="/users" exact component = {UpdateUser}/>
            </Switch>
        </BrowserRouter>
    );
}