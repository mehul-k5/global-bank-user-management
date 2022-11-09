import React from 'react';
import {Link } from "react-router-dom";
import '../menu.css'
import MyHeader from './MyHeader.js';
import MyFooter from './MyFooter';

export default function Menu() {
  return( 
    <div>
    <MyHeader/>
    <div className = "menu">
        <h1>User operations</h1>
        <div className="content">
            <br></br>
            <Link to="/applyLoan"><button>Apply for Loan</button></Link>
            <br></br><br></br>
            <Link to="/transaction"><button>Transactions</button></Link>
            <br></br><br></br>
            <Link to="/viewStatement"><button>View Statement</button></Link>
            <br></br><br></br>
            <Link to="/showLoans"><button>View Applied Loans</button></Link>
        </div>
    </div>
    <MyFooter/>
    </div>
  )
}
   