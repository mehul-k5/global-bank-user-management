import React, {useEffect, useState } from 'react';
import { useNavigate,Link } from "react-router-dom";
import '../transaction.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';

export default function Transaction() {
    const navigate = useNavigate();
    const options=[
        {value: 'deposit',name:'deposit'},
        {value:'withdraw',name:'withdraw'}
      ]
    const sendData=(e)=>{
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/transaction`,
                data: {transaction_number:transactionNumber,account_number:accountNumber,date_of_transaction:new Date().toISOString().split('T')[0],transaction_type:transactionType,medium_of_transaction:mediumOfTransaction,transaction_amount:transactionAmount},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  console.log(response);
                  if(response.data.status==="true"){
                   alert("Transaction submitted successfully,your available balance is "+response.data.balance);
                   navigate("/menu");
                  }
                  else{
                   alert("enter appropriate details");
                   navigate("/transaction");
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
    },[]);
    const [customerNumber,setCustomerNumber]=useState();
    const [transactionNumber, setTransactionNumber] = useState();
    const [accountNumber, setAccountNumber] = useState();
    // const [dateOfTransaction, setDateOfTransaction] = useState();
    const [transactionType, setTransactionType] = useState(); 
    const [mediumOfTransaction, setMediumOfTransaction]=useState();
    const [transactionAmount, setTransactionAmount]=useState();

    return( 
      <div className="Transaction">
      <MyHeader/>
      <div className="Transaction-form">
      <form action="">
        <h1>Transaction Page</h1>
        <div className="content">
          <div className="input-field">
            <label for="Customer number">Customer number:</label>
            {customerNumber}
          </div>
          <div className="input-field">
            <label for="Transaction Number">Transaction Number:</label> 
            <input type="text" required onChange={e=>setTransactionNumber(e.target.value)}/>
          </div>
          <div className="input-field">
            <label for="Account Number">Account Number</label>
            <input type="text" required onChange={e=>setAccountNumber(e.target.value)}/>
          </div>
            <div className="input-field">
          <label for="transaction type">Transaction type:</label>
            <select onChange={e => setTransactionType(e.target.value)}  defaultValue={"default"}>
            <option value={"default"} disabled>choose</option>
            {options.map(item => (
                <option key={item.value} value={item.name}>{item.name} </option>
            ))}
           </select>
           </div>
          <div className="input-field">
            <label for="Medium of Transaction">Medium of Transaction</label>
            <input type="text" required onChange={e=>setMediumOfTransaction(e.target.value)}/>
          </div>
          <div className="input-field">
            <label for="Transaction amount">Transaction amount</label>
            <input type="number" required onChange={e=>setTransactionAmount(e.target.value)}/>
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
     

   