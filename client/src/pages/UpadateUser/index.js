import React, {useEffect, useState} from 'react';
import { useHistory, useParams} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import { BiLogOut } from "react-icons/bi";

export default function UpdateUser(){

    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [email, setEmail] = useState('');
    const [endereco, setEndereco] = useState('');
    const [password, setPassword] = useState('');
    const nomeUser = localStorage.getItem('nome');
    const accessToken = localStorage.getItem('accessToken');

    const history = useHistory();

   


    async function updateUser(e){
        e.preventDefault();

        const data = {
            nome,
            cpf,
            email,
            endereco,
            password
        }
    
        try {
            await api.post("auth/singup", data ,{
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            });

            history.push('/')
        } catch (err) {
            alert('Preencha todos os campos e tente novamente!!!');
        }
    };




    async function  logout(){
        localStorage.clear();
        history.push('/');
    };

    return (
        <body>
            <header>
                <img src = {logo} id = "logo"/>

                <ul>
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

                <BiLogOut id = "btn-sair" onClick = {logout}/>

            </header>

            
            
            <div id="header2">
                <strong>Olá, {nomeUser.toUpperCase()}</strong>
            </div>

    <main id="main-cadastro">

        <section>
            <div id="dados-pessoais">

                <h1>SEUS DADOS</h1>
                <h2>Dados Pessoais</h2>

                <form onSubmit = {updateUser}>
                    <input type="text" name="nome" id="nome" class="input-atualizar" placeholder="  Nome"
                        value = {nome}
                        onChange={e => setNome(e.target.value)}
                    />
                    <input type="email" name="email" id="email"class="input-atualizar" placeholder="  E-mail"
                        value = {email}
                        onChange = {e => setEmail(e.target.value)}
                    />
                    <input type="text" name="cpf-cnpj" id="cpf-cnpj"class="input-atualizar" placeholder="  CPF/CNPJ"
                        value = {cpf}
                        onChange = {e => setCpf(e.target.value)}
                    />
                    <input type="text" name="endereco" id="endereco"class="input-atualizar" placeholder="  Endereço"
                        value = {endereco}
                        onChange = {e => setEndereco(e.target.value)}
                    />
                    <input type="password" name="senha" id="senha-nova"class="input-atualizar" placeholder="  Senha"
                        value = {password}
                        onChange = {e => setPassword(e.target.value)}
                    />
                    <input id="salvar-btn" type="submit" value="SALVAR ALTERAÇÕES"/>
                </form>

            </div>

        </section>

    </main>



       </body>
    )
}