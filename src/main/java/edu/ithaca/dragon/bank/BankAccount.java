package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     *  If the withdraw amount is > the current balance, the balance will be set to 0
     */
    public void withdraw (double amount)  {
        if(amount < balance)
            balance -= amount;
        else
            balance = 0;
    }

    /**
     * A valid email address:
     * (at least one character) + @ + (at least one character) + . + (at least one character)
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') < 1){
            return false;
        }
        int indexOAtSym = email.indexOf('@');
        if (email.lastIndexOf('@') != indexOAtSym){
            return false;
        }

        if (email.indexOf('.') < indexOAtSym + 2){
            return false;
        }
        return true;
    }
}
