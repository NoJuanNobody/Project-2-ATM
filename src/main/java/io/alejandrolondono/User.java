package io.alejandrolondono;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class User {

    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String first;
    private String last;
    private int pin;
    private String userId = "U"+UUID.randomUUID().toString();


    public User(String first, String last){
        this.first = first;
        this.last = last;

    }

    public void addAccount(Account acct){
        ArrayList<Account> accounts = this.getAccounts();
        accounts.add(acct);
    }

    /*
    getters and setters below
     */


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

//    public void setAccounts(ArrayList<Account> accounts) {
//        this.accounts = accounts;
//    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}
