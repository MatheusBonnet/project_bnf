import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import { useHistory} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { BsPersonCircle } from "react-icons/bs";

export default function Login(){
    const [cpf, setCpf] = useState('');
    const [password, setPassword] = useState('');

    const history = useHistory();

    async function login(e){
        e.preventDefault();

        const data = {
            cpf,
            password,
        };

        try {
            const response = await api.post('login', data);

            localStorage.setItem('accessToken', response.data);

            history.push('/doacoes')
        } catch (err) {
            alert('Insira os dados corretamente e tente novamente!!!');
        }
    };

    return (
        <body>
            <header>
                <Link to = {"/"}><img src = {logo} id = "logo"/></Link>

                <ul class="cabecalho">
                    <li id="pq-doar"><Link to = {"/"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/"}> DOAR JÁ </Link> </li>
                </ul>

                
            </header>

        <h1>LOGIN</h1>
        <p>É UM PRAZER TER VOCÊ AQUI!</p>

        

    <main>  
        <section>
        <div id = "login">
            <p class="p_login">Já tenho uma conta</p>

            <form onSubmit = {login}>
               <input id="user" type="text" placeholder="CPF/CNPJ"
                        value={cpf}
                        onChange={e => setCpf(e.target.value)}
               />

                <input id="senha" type="password" name = "senha" placeholder="Senha"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                />
              
                <p id="esqueceu_senha">Esqueci minha senha</p>
            
                <button id="entrar-btn" type="submit">ENTRAR</button>
            </form>
        </div>

        <div id ="cadastro">
            <p class="p_cad">Criar uma conta</p>
            <button id="criar-btn" value="CRIE UMA CONTA"><Link to = {"auth/singup"}> CADASTRE-SE AQUI</Link></button>
        </div>
        

        </section>

    </main>
     </body>
    )
}