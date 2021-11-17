import React, {useState} from 'react';
import { useHistory} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import { BsPersonCircle } from "react-icons/bs";

export default function UpdateUser(){

    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [email, setEmail] = useState('');
    const [endereco, setEndereco] = useState('');
    const [password, setPassword] = useState('');
    

    const history = useHistory();

    async function updateUSer(e){
        e.preventDefault();

        const data = {
            nome,
            cpf,
            email,
            endereco,
            password
        };

        try {
            await api.put('users', data);

            history.push('/')
        } catch (err) {
            alert('Preencha todos os campos e tente novamente!!!');
        }
    };

    return (
        <body>
            <header>
                <Link to = {"/"}><img src = {logo} id = "logo"/></Link>

                <ul>
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

                <Link to = {"/atualizarDados"}> <BsPersonCircle id = "logo"/></Link>

            </header>

            
        <h1>CADASTRO</h1>
        <h2>INICIE HOIJE UMA NOVA HISTÓRIA</h2>

    <main id="main-cadastro">

        <section>
            <div id="dados-pessoais">

                <h1>SEUS DADOS</h1>
                <h2>Dados Pessoais</h2>

                <form onSubmit = {updateUSer}>
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