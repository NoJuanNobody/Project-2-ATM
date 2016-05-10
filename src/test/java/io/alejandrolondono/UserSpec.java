package io.alejandrolondono;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/9/16.
 */
public class UserSpec {

    User newUser;
    Checking checkAcct;
    Savings saveAcct;
    Investment invAcct;
    double ammount;
    @Before
    public void Sandbox(){
        newUser = new User("Alex", "London", 1234);
        checkAcct = new Checking();
        saveAcct = new Savings();
        ammount = 50000;
        invAcct = new Investment(ammount);
        checkAcct.setBalance(ammount);
        saveAcct.setBalance(ammount);

    }

    @Test
    public void AddSavingsAcctTest(){
        String accountID = saveAcct.getAccountId();
        newUser.addAccount((Account)saveAcct);
        ArrayList<Account> accounts = newUser.getAccounts();
        String returnedAccountID="";
        for(Account account : accounts){
            if(accountID == account.getAccountId()){
                returnedAccountID =  account.getAccountId();
            }
        }
        assertEquals("should have returned the same ID", accountID, returnedAccountID);
    }


    @Test
    public void AddCheckingAcctTest(){
        String accountID = checkAcct.getAccountId();
        System.out.println(newUser.getUserID());
        newUser.addAccount((Account)checkAcct);
        ArrayList<Account> accounts = newUser.getAccounts();
        String returnAccountID="";
        for(Account account: accounts){
            if(accountID == account.getAccountId()) returnAccountID = account.getAccountId();
        }
        assertEquals("should have returned the account id for checking", accountID, returnAccountID);
    }

//    @Test
//    public void AddInvestmentAcctTest(){
//        String accountID = invAcct.getAccountId();
//        newUser.addAccount((Account)invAcct);
//        ArrayList<Account> accounts = newUser.getAccounts();
//        String returnAccountID="";
//        for(Account account: accounts){
//            if(accountID == account.getAccountId()) returnAccountID = account.getAccountId();
//        }
//        assertEquals("should have returned the account id for checking", accountID, returnAccountID);
//    }
}
