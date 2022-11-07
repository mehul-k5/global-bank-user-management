import React, {useState } from 'react';
import '../register.css'
import base_url from '../api/bootapi';
import axios from "axios";
export default function Register() {
    
    const sendData=(e)=>{
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/register`,
                data: {customerNumber:customernumber,firstName:firstname,lastName:lastname,customerCity:customercity,customerOccupation:customeroccupation,dateOfBirth:dateofbirth,password:password},
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
  const [customernumber, setCustomerNumber] = useState();
  const [firstname, setFirstName] = useState(); 
  const [lastname, setLastName] = useState(); 
  const [customercity, setCustomercity] = useState();
  const [customeroccupation, setCustomerOccupation] = useState();
  const [dateofbirth, setDateOfBirth] = useState();
  const [password, setPassword] = useState();

  return( 
    <div className="register-form">
    <form action="">
      <h1>Register</h1>
      <br></br>
      <div className="content">
        <div className="input-field">
            <label for="Customer Number">Customer Number:</label>
            <input type="text" id="customernumber" name="Customer Number" placeholder="123456" required onChange={e => setCustomerNumber(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="First Name">First Name:</label>
            <input type="text" id="firstname" name="First Name" placeholder="abcdef" required onChange={e => setFirstName(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Last Name">Last Name:</label>
            <input type="text" id="lastname" name="Last Name" placeholder="abcdef" required onChange={e => setLastName(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Customer City">Customer City:</label>
            <input type="text" id="customercity" name="Customer City" placeholder="abcdef" required onChange={e => setCustomercity(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Customer Occupation">Customer Occupation:</label>
            <input type="text" id="customeroccupation" name="Customer Occupation" placeholder="abcdef" required onChange={e => setCustomerOccupation(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Date Of Birth">Date Of Birth:</label>
            <input type="text" id="dateofbirth" name="Date Of birth" placeholder="DD-MM-YYYY" required onChange={e => setDateOfBirth(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Password">Password:</label>
            <input type="password" placeholder="Password" required onChange={e=>setPassword(e.target.value)}/>

        </div>
    
      </div>
      <div className="action">
        <button type="submit" onClick={sendData}>Register</button>
      </div>
    </form>
  </div>
  )
}
   
