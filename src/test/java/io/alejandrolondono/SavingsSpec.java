package io.alejandrolondono;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class SavingsSpec {
    Checking checking;
    Savings savings;
    double amount = 500;
    double withdraw;
    double err = 0.01;
    @Before
    public void Sandbox(){
        savings = new Savings(1.25, 20000);
        checking = new Checking(savings, amount);
        withdraw = 600;
    }

    @Test
    public void annualInterestTest(){
        double expectedValue = 3.570046715991974E7;
        double actualValue = savings.annualInterest(6);
        assertEquals("the compounded interest should give you a balance of: "+expectedValue, expectedValue, actualValue,err);

    }

}
