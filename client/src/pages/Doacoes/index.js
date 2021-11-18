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
    async function deleteDoacao(id) {
        try {
            await api.delete(`doacoes/${id}`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })

            setDoacoes(doacoes.filter(doacao => doacao.id !== id))
        } catch (err) {
            alert('Delete failed! Try again.');
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

                <ul>
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

                <BiLogOut id = "btn-sair" onClick = {logout}/>

                <Link to = {"users"}> <BsPersonCircle id = "perfil"/></Link>

            </header>
        
            <h1>INICIAR DOAÇÃO</h1>
            <h2>INCIE HOJE UMA NOVA DOAÇÃO</h2>

            <ul>
                {doacoes.map(doacao => 
                    <li key = {doacao.id}>
                        <strong>Tipo de Doação:</strong>
                        <p>{doacao.produto}</p> <br></br>

                        <strong>Telefone:</strong>
                        <p>{doacao.valor}</p><br></br>

                        <strong>Valor:</strong>
                        <p>{doacao.telefone}</p><br></br>

                        <strong>Descrição:</strong>                       
                        <p>{doacao.descricao}</p><br></br>         
                        
                    </li>
                )}
            </ul>

            
        </body>

        
    );
}