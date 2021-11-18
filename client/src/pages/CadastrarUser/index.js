import React, {useState} from 'react';
import { useHistory} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';

export default function CadastrarUser(){

    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [email, setEmail] = useState('');
    const [endereco, setEndereco] = useState('');
    const [password, setPassword] = useState('');

    localStorage.setItem("nome", nome);
    localStorage.setItem("cpf", cpf);

    const history = useHistory();

    async function clear() {
        localStorage.clear();
    }

    async function cadastrarUser(e){
        e.preventDefault();

        const data = {
            nome,
            cpf,
            email,
            endereco,
            password
        };

        try {
            const response = await api.post('auth/singup', data);

            history.push('/')
        } catch (err) {
            alert('Preencha todos os campos e tente novamente!!!');
        }
    };

    return (
        <body>
            <header>
                <Link to = {"/"} onClick = {clear}><img src = {logo} id = "logo"/></Link>

                <ul>
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/"}> DOAR JÁ </Link> </li>
                </ul>

            </header>

            
        <h1>CADASTRO</h1>
        <h2>INICIE HOIJE UMA NOVA HISTÓRIA</h2>

    <main id="main-cadastro">

            <div id="centro-cadastro">
                <form onSubmit = {cadastrarUser}>
                    <input type="text" name="nome" id="nome" class="input-cadastro" placeholder="  Nome"
                        value = {nome}
                        onChange={e => setNome(e.target.value)}
                    />
                    <input type="email" name="email" id="email"class="input-cadastro" placeholder="  E-mail"
                        value = {email}
                        onChange = {e => setEmail(e.target.value)}
                    />
                    <input type="text" name="cpf-cnpj" id="cpf-cnpj"class="input-cadastro" placeholder="  CPF/CNPJ"
                        value = {cpf}
                        onChange = {e => setCpf(e.target.value)}
                    />
                    <input type="text" name="endereco" id="endereco"class="input-cadastro" placeholder="  Endereço"
                        value = {endereco}
                        onChange = {e => setEndereco(e.target.value)}
                    />
                    <input type="password" name="senha" id="senha-cadastro"class="input-cadastro" placeholder="  Senha"
                        value = {password}
                        onChange = {e => setPassword(e.target.value)}
                    />
                    <input id="finalizar-cadastro" type="submit" value="FINALIZAR CADASTRO"/>
                </form>
            </div>

    </main>

       </body>
    )
}