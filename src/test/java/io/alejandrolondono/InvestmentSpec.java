package io.alejandrolondono;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by alejandrolondono on 5/7/16.
 */
public class InvestmentSpec {
    Investment investment;
    double amount = 500;
    double withdraw;
    double err = 0.01;
    @Before
    public void Sandbox(){
       investment = new Investment(100000);
        withdraw = 600;
    }

    @Test
    public void returnOnInvTest(){
        double previousValue = investment.getBalance();
        investment.returnOnInv(3);
        double newValue = investment.getBalance();
        boolean cond = newValue == previousValue;
        assertFalse(cond);
    }

}
