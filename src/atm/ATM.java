package atm;

import java.util.ArrayList;
import java.util.LinkedList;

public class ATM {

    String balance;
    String amount;
    ATM atm;

    public ATM() {
        balance = "0";
        amount = "0";

    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public String Balance() {

        return balance;

    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean withdraw(String amount) {
        boolean flag = true;
        int balance1 = Integer.parseInt(balance);
        int amount1 = Integer.parseInt(amount);
        if (amount1 <= balance1) {
            balance1 = balance1 - amount1;
            String balance2 = String.valueOf(balance1);
            String amount2 = String.valueOf(amount1);
            setBalance(balance2);

        } else {
            flag = false;
        }
        return flag;
    }

    public void deposit(String amount) {
        int balance1 = Integer.parseInt(balance);
        int amount1 = Integer.parseInt(amount);
        balance1 = balance1 + amount1;
        String amount2 = String.valueOf(amount1);
        String balance2 = String.valueOf(balance1);
        setBalance(balance2);

    }

}
