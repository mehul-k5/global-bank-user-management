import React, {useState } from 'react';
import '../login.css'
import base_url from '../api/bootapi';
import axios from "axios";
export default function Login() {
    
    const sendData=(e)=>{
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/login`,
                data: {userId:username,password:password},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  //handle success
                  if(response.data==="successful"){
                   console.log(response);
                  }
                  else{
                   console.log(response);
                  }
                  
                })
                .catch(function (response) {
                  //handle error
                  console.log(response);
                  
                });
         
    };
  const [username, setUserName] = useState();
  const [password, setPassword] = useState(); 
  return( 
    <div className="login-form">
    <form action="">
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
        <button type="submit" onClick={sendData}>Sign in</button>
      </div>
    </form>
  </div>
  )
}
   