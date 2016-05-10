package io.alejandrolondono;

/**
 * Created by alejandrolondono on 5/9/16.
 */
public interface Transaction {

    String credit(double amount);
    String debt(double amount);
    String transfer(Account acct, double amount);

}
