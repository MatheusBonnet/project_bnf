import React from 'react';
import entenda from '../../assets/entenda.png';
import logo from '../../assets/logo.png';
import { Link } from 'react-router-dom';
import '../../global.css';

export default function PorqueDoar(){
    
    
    return (
        <body>
    
            <header>
                <Link to = {"/"}><img src = {logo} id = "logo"/></Link>

                <ul>
                    <li id="pq-doar"><Link to = {"/porqueDoar"}> PORQUE DOAR? </Link> </li>
                    <li id="view-donate"><Link to = {"/doacoes"}> VER DOAÇÕES </Link> </li>
                    <li id="donate-now"><Link to = {"/cadastrarDoacao"}> DOAR JÁ </Link> </li>
                </ul>

            </header>

        <main>
                <div>
                    <img id="img-pq-doar" src={entenda} alt="img-entenda"/>
                </div>

                <h1>PORQUE DOAR?</h1>
                <p id="txt-pq-doar">O ato de doar bens materiais geralmente é uma
                    tarefa muito difícil. Muitas vezes nos apegamos emocionalmente aos
                    nossos objetos e mantemos eles em casa mesmo quando já não têm mais
                    utilidade… Quando se trata de roupas, o cenário se complica ainda
                    mais. Não nos livramos de peças de roupa pensando que futuramente
                    voltaremos a querer usá-las e elas ficam mofando (literalmente) até 
                    que já estejam muito desgastadas para serem doadas.

                    Além de liberar espaço nos armários e gavetas e ajudar os outros,
                    doar faz bem para a saúde do doador. Segundo os estudos, realizar
                    doações estimula a região do cérebro que nos dá prazer.
                </p>

        </main>

        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js" ></script>

        </body>
    );
}