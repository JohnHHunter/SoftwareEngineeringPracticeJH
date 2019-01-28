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
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}