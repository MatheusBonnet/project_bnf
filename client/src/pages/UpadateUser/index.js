import React, {useEffect, useState} from 'react';
import { useHistory, useParams} from 'react-router-dom';
import '../../global.css';
import logo from '../../assets/logo.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import { BiLogOut } from "react-icons/bi";
import { BiTrash } from 'react-icons/bi';

export default function UpdateUser(){

    const [id, setId] = useState(null);
    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [email, setEmail] = useState('');
    const [endereco, setEndereco] = useState('');
    const [password, setPassword] = useState('');
    const nomeUser = sessionStorage.getItem('nome');
    const accessToken = localStorage.getItem('accessToken');
    const [doacoes, setDoacoes] = useState([]);
    const history = useHistory();
    const {userId} = useParams();


   /* async function loadUser() {
        try {
            const response = await api.get(`users/${userId}`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })

            setId(response.data.id);
            setNome(response.data.nome);
            setCpf(response.data.cpf);
            setEmail(response.data.email);
            setEmail(response.data.endereco);
            setPassword(response.data.password);
   
        }catch (error){
            alert('Erro ao recuperar o usuario! Tente novamente!');
            history.push('/atualizarDados');
        }   
    }*/

    useEffect(() => {
        if (userId === '0') return;
    }, [userId])

   /* async function updateUser(e){
        e.preventDefault();

        const data = {
            nome,
            cpf,
            email,
            endereco,
            password
        }
    
        try {
            data.id = id;
            await api.put("users", data ,{
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            });

            history.push('/')
        } catch (err) {
            alert('Preencha todos os campos e tente novamente!!!');
        }
    };*/

    useEffect(() => {
        api.get('doacoes' , {
        headers: {
            Authorization: `Bearer ${accessToken}`
            }
        }).then(response => {
            setDoacoes(response.data.content)
        })
    }, []);

    async function  logout(){
        localStorage.clear();
        history.push('/');
    };

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

    return (
        <body>
            <header>
                <img src = {logo} id = "logo"/>

                <ul class="cabecalho">
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

                <BiLogOut id = "btn-sair" onClick = {logout}/>

            </header>

            
            
            <div id="header2">
                <strong class="ola">Olá, {nomeUser}</strong>
            </div>

    <div class="controla-perfil">

        <section id="dados-pessoais">
            <div class="controla-campos">

                <h1>SEUS DADOS</h1>
                <h2>Dados Pessoais</h2>

                <form class="form-update">
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

        <div class="control-doacao-perfil">
                <ul class="caixa-doacao-perfil">
                    {doacoes.map(doacao => 
                        <li class="info-caixa-doacao-perfil" key = {doacao.id}>
                            
                            <div class="separa">
                                <div class="tipo-doacao">
                                    <strong>{nomeUser}</strong> está doando: {doacao.produto}
                                </div> 

                                <div class="campo-lixeira">
                                    <p id="ativo">Ativo</p>
                                    <BiTrash id = "lixeira" onClick = {() => deleteDoacao(doacao.id)}></BiTrash>
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
                            
                        </li>
                    )}
                </ul>
            </div>
    </div>



       </body>
    )
}