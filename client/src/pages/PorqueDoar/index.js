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
                <p id="txt-pq-doar">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Adipisci nisi, esse eveniet voluptatibus placeat 
                odio maxime facilis! Aliquid, cupiditate nulla,
                aperiam magni eius ea sequi aspernatur non, exercitationem explicabo ullam.</p>

        </main>

        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js" ></script>

        </body>
    );
}