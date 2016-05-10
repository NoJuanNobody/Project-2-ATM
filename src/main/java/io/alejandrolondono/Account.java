package io.alejandrolondono;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by alejandrolondono on 5/7/16.
 */
abstract public class Account implements Transaction{

    private String AccountId = UUID.randomUUID().toString();
    private double balance=0;
    private ArrayList<String> transactions = new ArrayList<String>();
    private Status accountStatus = Status.OPEN;

    public String credit(double amount){
        String msg="";
        if(this.getAccountStatus() == Status.OPEN){
            this.setBalance(this.getBalance()+amount);
            this.transactions.add("+"+amount);
            msg ="credited your acount: "+amount;
        }
        return msg;
    }

    public String debt(double amount){
        String msg="";
        if(this.getAccountStatus() == Status.OPEN && !isOverdraft(amount)){
            this.setBalance(this.getBalance()-amount);
            this.transactions.add("-"+amount);
            msg="your account has been debited "+amount;
        }
        return msg;
    }

    public String transfer(Account acct, double amount){
        String msg ="";
        if(this.getAccountStatus() == Status.OPEN && !isOverdraft(amount)){
            this.debt(amount);
            acct.credit(amount);
            msg="transfered funds FROM AccountID: "+acct.getAccountId()+"\n"+"transfered funds TO AccountID: "+acct.getAccountId();
        }
        return msg;
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }



    public void changeStatus(String status){
        setAccountStatus(Status.valueOf(status.toUpperCase()));
    }

    public String getAccountId() {
        return AccountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public Account(){}

    public Account(double amount){
        this.setBalance(amount);
    }

    public boolean isOverdraft(double amount){
        return amount > this.getBalance();
    }

}
