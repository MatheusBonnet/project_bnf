import React, {useState, useEffect} from 'react';
import { Link } from 'react-router-dom';
import { useHistory} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { BsPersonCircle } from "react-icons/bs";
import { BiLogOut } from 'react-icons/bi';


export default function Doacoes(){

    const [doacoes, setDoacoes] = useState([]);
    const accessToken = localStorage.getItem('accessToken');
    const nomeUser = sessionStorage.getItem('nome');
    const history = useHistory();


    async function editarDoacao(id) {
        try {
            await api.put(`doacoes/${id}`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })
        } catch (error) {
            alert('Edit failed! Try again.');
        }
    }

    async function  logout(){
        localStorage.clear();
        history.push('/');
    };

    useEffect(() => {
        api.get('doacoes' , {
        headers: {
            Authorization: `Bearer ${accessToken}`
            }
        }).then(response => {
            setDoacoes(response.data.content)
        })
    }, []);
    
    return (

        <body>
            <header>
                <img src = {logo} id = "logo"/>

                <ul class="cabecalho">
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

                <Link to = {"/atualizarDados"}><BsPersonCircle id = "perfil"/></Link>

                <BiLogOut id = "btn-sair" onClick = {logout}/>

            </header>
        
            <h1>INICIAR DOAÇÃO</h1>
            <h2>INICIE HOJE UMA NOVA DOAÇÃO</h2>

            <div class="control-doacao" value="caixaDoacao">
                <ul class="caixa-doacao">
                    {doacoes.map(doacao => 
                        <li class="info-caixa-doacao" key = {doacao.id}>
                            
                            <div class="separa">
                                <div class="tipo-doacao">
                                    <strong>{nomeUser}</strong> está doando: {doacao.produto}
                                </div> 

                                <div class="campo-lixeira">
                                    <p id="ativo">Ativo</p>
                                </div>
                            </div>

                            <div class="qtde-doacao">
                                <strong>Quantidade / Valor: </strong>
                                {doacao.valor}
                            </div>

                            <div class="desc-doacao">
                                <strong>Descrição: </strong>                       
                                {doacao.descricao}        
                            </div>
                            
                            <div class="tel-doacao">
                                <a id="btn-cnt" href="{doacao.telefone}">ENTRE EM CONTATO</a>
                            </div>

                        </li>
                    )}
                </ul>
            </div>

            
        </body>

        
    );
}