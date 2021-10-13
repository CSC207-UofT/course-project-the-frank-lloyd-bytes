// This class will hold financial information linked to unique userID
// It will allow methods to 1. Load funds 2. Check Balance 3. Deduct Funds 4. Provide Transaction History
// It might be better to make this a 'Card class' with limited basic functionality, then extend the financial abilities.
// But for the time being we can make it simple.

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Wallet {
    double balance;
    HashMap<Double, Date> transaction;
    ArrayList<HashMap> transactionRecord;
    Date today;

  private void wallet(){
//      TODO initialize wallet without funds from load data
  }
  private void wallet(double amount){
      this.balance = amount;
//      TODO initialize wallet with funds and add date and amount to transaction & record.
  }

//  TODO method creates transaction. This is rudimentary example... Need subtraction, etc..
    protected boolean addTransaction(Double amount, Date date){
      if (amount > 0.0){
          this.transaction.put(amount, date);
          this.balance += amount;
          return true;
      }
      return false;

    }

//    TODO method adds transaction to transactionRecord

//    TODO method sets level for balance alert.(or this could be in USER class... need to think)

//     TODO method to set transaction, transactionRecord, and balance string display properties.


}
