package io.alejandrolondono;

import java.util.Random;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class Investment extends Account{
    Random randy = new Random();

    public void returnOnInv(double years){
        setBalance(this.getBalance()*(1+0.3)*years);

    }

    public Investment(double amount){
        super(amount);
    }
}
