import React, {useState } from 'react';
import '../register.css'
import base_url from '../api/bootapi';
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';
export default function Register() {
    const navigate = useNavigate();
    const sendData=(e)=>{
      
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/register/${password}`,
                data: {customer_number:customernumber,firstname:firstname,middlename:middlename,lastname:lastname,customer_city:customercity,customer_contact_no:contact,occupation:customeroccupation,customer_date_of_birth:dateofbirth},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  //handle success
                  if(response.data!=null){
                   console.log(response);
                   navigate("/login");
                  }
                  else{
                   console.log(response);
                   alert("enter correct details to register successfully");
                   navigate("/register");
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
  const [middlename,setMiddleName]=useState();
  const [customercity, setCustomercity] = useState();
  const [customeroccupation, setCustomerOccupation] = useState();
  const [dateofbirth, setDateOfBirth] = useState();
  const [password, setPassword] = useState();
  const [contact,setContact]=useState();

  return( 
    <div>
      <MyHeader/>
    <div className="register-form">
    
    <form action="">
      <h1>Register</h1>
      <br></br>
      <div className="content">
        <div className="input-field">
            <span>
            <label for="Customer Number">Customer Number:</label>
            <input type="text" id="customernumber" name="Customer Number" placeholder="123456" required onChange={e => setCustomerNumber(e.target.value)}/>
            </span>
            <br></br>
            <br></br>
            <label for="First Name">First Name:</label>
            <input type="text" id="firstname" name="First Name" placeholder="John" required onChange={e => setFirstName(e.target.value)}/>
            <br></br>
            <label for="Middle Name">Middle Name:</label>
            <input type="text" id="middlename" name="Middle Name" placeholder="A" required onChange={e => setMiddleName(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Last Name">Last Name:</label>
            <input type="text" id="lastname" name="Last Name" placeholder="Doe" required onChange={e => setLastName(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Customer City">Customer City:</label>
            <input type="text" id="customercity" name="Customer City" placeholder="Mumbai" required onChange={e => setCustomercity(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Customer Occupation">Customer Occupation:</label>
            <input type="text" id="customeroccupation" name="Customer Occupation" placeholder="Engineer" required onChange={e => setCustomerOccupation(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Date Of Birth">Date Of Birth:</label>
            <input type="date" id="dateofbirth" name="Date Of birth" placeholder="YYYY-MM-DD" required onChange={e => setDateOfBirth(e.target.value)}/>
            <br></br>
            <br></br>
            <label for="Contact number">Contact number:</label>
            <input type="text" id="contact" name="contact" placeholder="9876543210" required onChange={e => setContact(e.target.value)}/>
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
  <MyFooter/>
  </div>
  )
}
   
