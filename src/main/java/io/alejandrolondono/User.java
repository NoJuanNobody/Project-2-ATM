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
    private String userHash = "U"+UUID.randomUUID().toString();
    private String userID = userHash.substring(userHash.length()-7);

    public User(String first, String last, int pin){
        this.first = first;
        this.last = last;
        this.pin = pin;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void addAccount(Account acct){
        this.accounts.add(acct);
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

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }



}
