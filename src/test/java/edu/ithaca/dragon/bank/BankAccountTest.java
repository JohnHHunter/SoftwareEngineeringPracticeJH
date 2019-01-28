package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());
        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());
        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());


        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw( -100));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw( 100.123));
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("myEmail@.com"));
        assertFalse(BankAccount.isEmailValid("@google.com"));
        assertFalse(BankAccount.isEmailValid(".@asd"));
        assertFalse(BankAccount.isEmailValid("a.a@a"));
        assertFalse(BankAccount.isEmailValid("a@a@a.a"));
    }

    @Test
    void isAmountValidTest(){
        assertTrue(BankAccount.isAmountValid(100.00));
        assertTrue(BankAccount.isAmountValid(1.11));
        assertTrue(BankAccount.isAmountValid(0.00));
        assertTrue(BankAccount.isAmountValid(0.0));
        assertTrue(BankAccount.isAmountValid(10));
        assertTrue(BankAccount.isAmountValid(10.1));
        assertFalse(BankAccount.isAmountValid(10.011));
        assertFalse(BankAccount.isAmountValid(-10.0));
        assertFalse(BankAccount.isAmountValid(-20.00));
        assertFalse(BankAccount.isAmountValid(-30));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));

        //Test that valid amounts are given
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("asd@asd.asd", -100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("asd@asd.asd", 123.123));


    }

}