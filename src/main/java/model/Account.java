package model;

import java.util.ArrayList;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Account {

    private String holder;
    private String pixKey;
    private double balance;
    private ArrayList<Pix> pixRecords;

    public Account(String holder, String pixKey, double saldo) {
        this.holder = holder;
        this.pixKey = pixKey;
        this.balance = saldo;
        this.pixRecords = new ArrayList<>();
    }

    public boolean creditBalance(double value) {
        balance += value;
        return true;
    }

    public boolean debitBalance(double value) {
        if (value > balance) {
            return false;
        }
        balance -= value;
        return true;
    }

    public String getHolder() {
        return holder;
    }

    public String getPixKey() {
        return pixKey;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Pix> getPixRecords() {
        return pixRecords;
    }

    @Override
    public String toString() {
        return "Titular: " + getHolder()
                + "\nChave Pix: " + getPixKey()
                + "\nSaldo: " + getBalance();
    }

    public boolean addPixAsPayee(String pixKey, double value) {
        if (creditBalance(value)) {
            Pix pix = new Pix(pixKey, value, PixType.PAYEE);
            pixRecords.add(pix);
            return true;
        }
        return false;
    }

    public boolean addPixAsPayer(String pixKey, double value) {
        if (debitBalance(value)) {
            Pix pix = new Pix(pixKey, value, PixType.PAYER);
            pixRecords.add(pix);
            return true;
        } 
        return false;
    }

    public void printPayments() {
        System.out.println("\n\nPAYMENTS =================================");
        for (Pix pix : getPixRecords()) {
            pix.toString();
        }
    }

}
