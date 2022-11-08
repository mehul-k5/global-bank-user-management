import React, {useEffect, useState } from 'react';
import { useNavigate,Link } from "react-router-dom";
import '../applyLoan.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';

export default function ApplyLoan() {

    const navigate = useNavigate();
    const [branches, setBranches] = React.useState([]);
    React.useEffect(() => {
      async function getBranches() {
        axios({
          method: "get",
          url:`${base_url}/branches`
        })
          .then(function (response) {
            setBranches(response.data);
            console.log(branches);
           
          })
          .catch((e) => {
          console.log(e);
        });
       
      }
      getBranches();
    }, []);
    const sendData=(e)=>{
           console.log("branch issssss ",branch);
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/apply`,
                data: {customer_number:customerNumber,branch_id:branch,loan_amount:loanAmount},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  console.log(response);
                  if(response.data==true){
                   alert("Loan application submitted successfully");
                   navigate("/menu");
                  }
                  else{
                   alert("enter appropriate details");
                   navigate("/applyLoan");
                  }
                  
                })
                .catch(function (response) {
                  //handle error
                  console.log(response);
                  alert("error occured,enter proper details");
                  navigate("/login")
                });
         
    };
    useEffect(()=>{
      const user=localStorage.getItem("customerNum");
      setCustomerNumber(user);
    })
    
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
            {customerNumber}
          </div>
          <div className="input-field">
            <label for="branch">Branch:</label> 
            <select onChange={e => setBranch(e.target.value)} defaultValue={"default"}>
              <option value={"default"} disabled>choose</option>
              {branches.map(item => (
                  <option key={item.branch_id} value={item.branch_id}>{item.branch_name} </option>
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
     

   