package io.alejandrolondono;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/7/16.
 */
public class CheckingSpec {

    Checking checking;
    Savings savings;
    double amount = 500;
    double withdraw;
    double err = 0.01;
    @Before
    public void Sandbox(){
        savings = new Savings(0.3, 20000);
        checking = new Checking(savings, amount);
        withdraw = 600;
    }

    @Test
    public void coverOverdraftCheckingTest(){
        double balance = checking.getBalance();
        double newBalance =balance - withdraw;
        checking.setBalance(newBalance);
        checking.coverOverdraft(withdraw);
        double actualBalance = checking.getBalance();
        double expectedbalance = 50;
        assertEquals("the balance should now be 50", expectedbalance, actualBalance, err);

    }

    @Test
    public void coverOverdraftSavingsTest(){
        checking.coverOverdraft(withdraw);
        double expectedSavings = 20000 + amount - withdraw - 50;
        double actualSavings = savings.getBalance();
        assertEquals("the savings should be "+expectedSavings, expectedSavings, actualSavings, err);

    }

    @Test
    public void ChangeCheckingStatusTest(){
        checking.changeStatus("closed");
        Status actualStatus = checking.getAccountStatus();
        Status expectedStatus = Status.CLOSED;
        assertEquals("the status should be: "+expectedStatus,expectedStatus,actualStatus);
    }
}
