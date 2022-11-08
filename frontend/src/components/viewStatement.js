import React, {useState } from 'react';
import { useNavigate} from "react-router-dom";
import '../viewStatement.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter.js';


export default function ViewStatement() {
    const navigate = useNavigate();
    const sendData=(e)=>{
           
            e.preventDefault();
            axios({
                method: "post",
                url:`${base_url}/viewStatement`,
                data: {customer_number:customerNumber,transaction_type:transactionType,from_date:fromDate,to_date:toDate},
                headers: { "Content-Type": 'application/json' },
              })
                .then(function (response) {
                  //handle success
                 
                  if(response.data==="successful"){
                   console.log(response);
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
    {value: 'deposit',name:'deposit'},
    {value:'withdraw',name:'withdraw'}
]
  const [customerNumber, setCustomerNumber] = useState();
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
          <input type="text" placeholder="Customer number" required onChange={e => setCustomerNumber(e.target.value)}/>
        </div>
        <div className="input-field">
          <label for="transaction type">Transaction type:</label>
          
          <select onChange={e => setTransactionType(e.target.value)}>
            {options.map(item => (
                <option key={item.value} value={item.name}>{item.name} </option>
            ))}
           </select>
           
        </div>
        <div className="input-field">
          <label for="from date">Transaction period from:</label>
          <input type="date" placeholder="YYYY-MM-DD" required onChange={e=>setFromDate(e.target.value)}/>
        </div>
        <div className="input-field">
          <label for="To date">Transaction period to:</label>
          <input type="date" placeholder="YYYY-MM-DD" required onChange={e=>setToDate(e.target.value)}/>
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
   