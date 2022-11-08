import React, {useState } from 'react';
import { useNavigate,Link } from "react-router-dom";
import '../menu.css'
import base_url from '../api/bootapi';
import axios from "axios";

export default function Menu() {
//     const navigate = useNavigate();
//     const sendData=(e)=>{
           
//             e.preventDefault();
//             axios({
//                 method: "post",
//                 url:`${base_url}/login`,
//                 data: {userId:username,password:password},
//                 headers: { "Content-Type": 'application/json' },
//               })
//                 .then(function (response) {
//                   //handle success
                 
//                   if(response.data==="successful"){
//                    console.log(response);
//                    navigate("/menu");
//                   }
//                   else{
//                    console.log(response);
//                    navigate("/register");
//                   }
                  
//                 })
//                 .catch(function (response) {
//                   //handle error
//                   console.log(response);
//                   alert("error occured,enter proper details");
//                   navigate("/login")
//                 });
         
//     };
//   const [username, setUserName] = useState();
//   const [password, setPassword] = useState(); 
  return( 
    <div classname = "menu">
        <h1>Menu</h1>
        <div classname="content">
            <br></br>
            <Link to="/loan">Apply for Loan</Link>
            <br></br>
            <Link to="/transaction">Transactions</Link>
            <br></br>
            <Link to="/statement">View Statement</Link>
        </div>
    </div>
  )
}
   