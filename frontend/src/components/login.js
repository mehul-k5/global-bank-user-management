import React, { useState } from 'react';
import '../login.css'
import base_url from '../api/bootapi';
import axios from "axios";

export default function Login() {
    const sendData=()=>{
            console.log("in handler");
           /* axios.get(`${base_url}/login`,JSON.stringify({ username, password }))
            .then((response)=>{
                console.log("success");
                console.log(response);
            },(error)=>{
                console.log("error");
                console.log(error)
            }
    
            );*/
            axios({
                method: "post",
                url: `${base_url}/login`,
                data: dataInput,
                headers: { "Content-Type": "multipart/form-data" },
              })
                .then(function (response) {
                  //handle success
                  console.log(response);
                })
                .catch(function (response) {
                  //handle error
                  console.log(response);
                });
         
    };
  const [username, setUserName] = useState();
  const [password, setPassword] = useState();
  const[dataInput, setDataInput]=useState(""); 
  const submitThis=()=>{
	const info={username:username,password:password}; 
	setDataInput([info]);
    sendData();
}
  return( 
    <div className="login-form">
    <form action="" onSubmit={submitThis}>
      <h1>Login</h1>
      <div className="content">
        <div className="input-field">
          <input type="text" placeholder="username" required onChange={e => setUserName(e.target.value)}/>
        </div>
        <div className="input-field">
          <input type="password" placeholder="Password" required onChange={e=>setPassword(e.target.value)}/>
        </div>
      </div>
      <div className="action">
        <button type="submit">Sign in</button>
      </div>
    </form>
  </div>
  )
}