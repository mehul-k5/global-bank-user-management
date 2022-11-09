import React, {useEffect, useState } from 'react';
import { useNavigate,Link, Navigate } from "react-router-dom";
import '../showLoans.css'
import base_url from '../api/bootapi';
import axios from "axios";
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';

export default function ShowLoans() {
    const [Loans, setLoans] = React.useState([]);
    const navigate=useNavigate();
    React.useEffect(() => {

      function getLoans() {
        const user=localStorage.getItem("customerNum");
        console.log(user);
        axios({
          method: "get",
          url:`${base_url}/getAllLoans/${user}`
        })
          .then(function (response) {
            console.log(response);
            setLoans(response.data);
            console.log(Loans);
            if(Loans.length==0)
            {
                alert("There are no loans");
                navigate("/menu")
            }
           
          })
          .catch((e) => {
          console.log(e);
        });
       
      }
      getLoans();
    }, []);
    return( 
    <div>
    <MyHeader/>
    <div className = "appliedLoans">
    <h1>Applied Loans</h1>
    <div className="content">
    
    <table id="loanTable">
        <tr>
          <td>Branch_id</td>
          <td>Loan Amount</td>
        </tr>
         {Loans.map((item,index)=>(
          <tr data-index={index}>
          <td>{item.branch_id}</td>
          <td>{item.loan_amount}</td>
          </tr>
         )
          
        )}
    </table>
    
    
    </div>
    </div>
    <center><Link to="/menu">Back to menu</Link></center>
    <MyFooter/>
    </div>
    )
  }
     

   