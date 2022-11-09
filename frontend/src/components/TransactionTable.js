export default function TransactionTable({transaction_details}){
    return (
        <div>
        <p>transaction table</p>
        {transaction_details}
        <table>
         { transaction_details.map((item,index)=>(
          <tr data-index={index}>
          <td>{item.transaction_number}</td>
          <td>{item.account_number}</td>
          <td>{item.date_of_transaction}</td>
          <td>{item.medium_of_transaction}</td>
        </tr>
         )
          
        )}
        </table>
      </div>
        
    )
    
}
        
