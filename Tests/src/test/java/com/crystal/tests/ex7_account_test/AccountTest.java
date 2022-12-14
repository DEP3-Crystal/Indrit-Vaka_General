package com.crystal.tests.ex7_account_test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assertions.assertEquals(0d,account.getOverdraftLimit(),epsilon);
    }
    @Test
    public void accountCannotHaveNegativeDepositAndWithdraw() {
        Account account = new Account(20);

        Assertions.assertFalse(account.withdraw(-20));
        Assertions.assertFalse(account.deposit(-10));
    }
    @Test
    public void accountCannotOverstepOverdraftLimit(){
        Account account = new Account(10);
        Assertions.assertFalse(account.withdraw(20));
    }
    @Test
    public void accountDepositAndWithdrawCorrectAmount(){
        Account account = new Account(10);
        Assertions.assertTrue(account.deposit(20));
        Assertions.assertTrue(account.withdraw(15));
    }
    @Test
    public void accountDepositAndWithdrawCorrectAmountReturned(){
        Account account = new Account(10);
        account.deposit(20);
        Assertions.assertEquals(20.0,account.getBalance(),epsilon);
        account.withdraw(15);
        Assertions.assertEquals(5.0,account.getBalance(),epsilon);
    }
}