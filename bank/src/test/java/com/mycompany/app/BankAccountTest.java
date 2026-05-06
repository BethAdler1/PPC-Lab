package com.mycompany.app;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    int[] numbers = {20,25,30,45}; 
    String strOne = "JavaTest";
    String strTwo = "JavaTest";
    private BankAccount account;

    @BeforeEach 
    void setUp() {
        // Starts each test with a fresh account of 100.0
        account = new BankAccount(100.0);
    }

    /** 1. Add an @AfterEach annotation and method to delete the current bank account to make it available for garbage collection */
    @AfterEach
    void tearDown() {
        account = null;
    }

    @Test
    void testDeposit() {
    /** 2. Adeposit $50 and check that the balance is 150 */
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after depositing 50");
    }

    @Test
    void testWithdraw() {
    /** 3. withdraw $40 and check that the balance is $60; remember that each test is done on a fresh instance of bank account */
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "balance should be 60 after withdrawing 40");

    }

    @Test
    void testInvalidDeposit() {
    /** 4. Deposit a negative amount and check if an exception is thrown */
        assertThrows(IllegalArgumentException.class, () -> { 
            account.deposit(-10.0);

        });
}

    @Test
    void testOverdraft() {
    /** 5. Verify that Withdrawing more than the current balance
    throws an exception */
        assertThrows(IllegalArgumentException.class, () -> { 
            account.withdraw(200.0);
        });
    }

    @Test
    void testNegativeInitialBalance(){
    /** 6. Add a test to check that an Exception is thrown when
    trying to create a new bankaccout with a negaive initial balance */
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0);
        });
    }
    @Test
    void testTransfer() {
        //test transfer logic
        BankAccount otherAcc = new BankAccount(50.0);
        account.transfer(otherAcc, 30.0);
        assertEquals(70.0, account.getBalance(), "Source account should have 70 left");
        assertEquals(80.0, otherAcc.getBalance(), "Target account should now have 80");
    }
    //2. write a JUMit test assuming you have an array of int values and you only want the jUnit test to fail if any of the values are less than 20
    @Test
    void testArrayValsNotLessThan20(){
        for(int val: numbers){
            assertTrue(val >= 20, "Failed:found a value (" + val + ") less than 20");
    }
}
    //3. write a JUnit test assuming you have two String references names strOne and strTwo and you only want it to pass if the two Strings contain the same characters.
    @Test
    void testStringsHaveSameCharacters() {
        //assertEquals checks if the content is the same
        assertEquals(strOne, strTwo, "The strings do not contain the same characters");
    }
}
