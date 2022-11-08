import React, {useState } from 'react';
import { useNavigate,Link } from "react-router-dom";
import '../applyLoan.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';

export default function ApplyLoan() {
    const navigate = useNavigate();
    const sendData=(e)=>{
           
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/apply`,
                data: {customer_number:customerNumber,branch_id:branch,loanAmount:loanAmount},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  //handle success
                 
                  if(response.data==="true"){
                   console.log(response);
                   alert("Loan application submitted successfully");
                   navigate("/menu");
                  }
                  else{
                   console.log(response);
                   navigate("/register");
                  }
                  
                })
                .catch(function (response) {
                  //handle error
                  console.log(response);
                  alert("error occured,enter proper details");
                  navigate("/login")
                });
         
    };
    const options=[
        {value: 'san francisco',name:'san francisco'},
        {value:'chicago',name:'chicago'}
    ]
    const [customerNumber, setCustomerNumber] = useState();
    const [branch, setBranch] = useState(); 
    const [loanAmount,setLoanAmount]=useState();
    return( 
      <div className="loan">
      <MyHeader/>
      <div className="loan-form">
      <form action="">
        <h1>Loan Application Page</h1>
        <div className="content">
          <div className="input-field">
            <label for="Customer number">Customer number:</label>
            <input type="text" placeholder="Customer number" required onChange={e => setCustomerNumber(e.target.value)}/>
          </div>
          <div className="input-field">
            <label for="branch">Branch:</label>
            
            <select onChange={e => setBranch(e.target.value)}>
              {options.map(item => (
                  <option key={item.value} value={item.name}>{item.name} </option>
              ))}
             </select>
             
          </div>
          <div className="input-field">
            <label for="Loan amount">Loan amount</label>
            <input type="number" required onChange={e=>setLoanAmount(e.target.value)}/>
          </div>
          
        </div>
        <div className="action">
          <button type="submit" onClick={sendData}>Submit</button>
        </div>
      </form>
     
    </div>
    <MyFooter/>
    </div>
    )
  }
     

   