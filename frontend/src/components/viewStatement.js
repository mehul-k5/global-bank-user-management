import React, {useState,useEffect } from 'react';
import { useNavigate} from "react-router-dom";
import '../viewStatement.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter.js';
import TransactionTable from './TransactionTable';


export default function ViewStatement() {
    const navigate = useNavigate();
    const [transactions, setTransactions] = React.useState([]);
    async function sendData(e){
           
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/statement`,
                data: {account_number:accountNumber,type_of_transaction:transactionType,fromDate:fromDate,toDate:toDate},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  //handle success
                
                  if(response.data.length>0){
                   
                   setTransactions(response.data);
                   console.log(transactions);
                  
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
    {value: 'deposit',name:'deposit'},
    {value:'withdraw',name:'withdraw'},
    {value:'all',name:'all'}
  ]
  useEffect(()=>{
    const user=localStorage.getItem("customerNum");
    setCustomerNumber(user);
  })
  const [customerNumber, setCustomerNumber] = useState();
  const [accountNumber, setAccountNumber] = useState();
  const [fromDate, setFromDate] = useState(); 
  const [toDate,setToDate]=useState();
  const [transactionType,setTransactionType]=useState();
  return( 
    <div className="statement">
    <MyHeader/>
    <div className="statement-form">
    <form action="">
      <h1>View Statement</h1>
      <div className="content">
        <div className="input-field">
          <label for="Customer number">Customer number:</label>
          {customerNumber}
        </div>
        <div className="input-field">
          <label for="Account number">Account number:</label>
          <input type="text" placeholder="Account number" required onChange={e => setAccountNumber(e.target.value)}/>
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
          <label for="from date">Transaction period from:</label>
          <input type="text" placeholder="YYYY-MM-DD" required onChange={e=>setFromDate(e.target.value)}/>
        </div>
        <div className="input-field">
          <label for="To date">Transaction period to:</label>
          <input type="text" placeholder="YYYY-MM-DD" required onChange={e=>setToDate(e.target.value)}/>
        </div>
      </div>
      <div className="action">
        <button type="submit" onClick={sendData}>Submit</button>
      </div>
    </form>
   
  </div>
  <TransactionTable transaction_details={transactions}/>
  <MyFooter/>
  </div>
  )
}
   