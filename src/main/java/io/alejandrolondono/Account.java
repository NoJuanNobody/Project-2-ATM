package io.alejandrolondono;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class Account {

    private String AccountId = UUID.randomUUID().toString();
    private double balance=0;
    private ArrayList<String> transactions = new ArrayList<String>();

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
