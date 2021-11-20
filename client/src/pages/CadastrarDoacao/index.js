import React, {useState} from 'react';
import { useHistory} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import { BsPersonCircle } from "react-icons/bs";
import { BiLogOut } from 'react-icons/bi';

export default function CadastrarDoacao(){

    const [produto, setProduto] = useState('');
    const [telefone, setTelefone] = useState('');
    const [descricao, setDescricao] = useState('');
    const [valor, setValor] = useState('');
    const accessToken = localStorage.getItem('accessToken');

    const history = useHistory();

    async function cadastrarDoacao(e){
        e.preventDefault();

        const data = {
            descricao,
            valor,
            telefone,
            produto
        };

        try {
            await api.post("doacoes", data, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })

            history.push("/doacoes");

        } catch (err) {
            alert('Prencha todos os campos corretamente!!!');
        }
    }

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

                <Link to = {"/atualizarDados"}> <BsPersonCircle id = "perfil"/></Link>

            </header>

            
        <h1>CADASTRO</h1>
        <h2>INICIE HOIJE UMA NOVA HISTÓRIA</h2>

        <main id="centro-cadastro-doacao">

    <div id="centro-cadastro">

        <form onSubmit = {cadastrarDoacao}>

            <input type="text" name="tipo" id="tipo" class="input-cadastro" placeholder="  Tipo da doação"
                value = {produto}
                onChange = {e => setProduto(e.target.value)}
            />
            <input type="" name="valor" id="tipo" class="input-cadastro" placeholder=" Qual a quantidade a ser doada?"
                value = {valor}
                onChange = {e => setValor(e.target.value)}
            />
            <input type="tel" name="telefone" id="telefone"class="input-cadastro" placeholder="  Telefone"
                value = {telefone}
                onChange = {e => setTelefone(e.target.value)}
            />
            <textarea id="descricao-produto" cols="0" rows="8" placeholder="  Descricao"
                value = {descricao}
                onChange = {e => setDescricao(e.target.value)}
            />
            <input id="finalizar-cadastro" type="submit" value="FINALIZAR CADASTRO DA DOAÇÂO"/>

        </form>
    </div>

</main>


    </body>
    )
}