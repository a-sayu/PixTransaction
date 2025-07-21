package model;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Account {

    private String holder;
    private String pixKey;
    private double balance;

    public Account(String holder, String pixKey, double saldo) {
        this.holder = holder;
        this.pixKey = pixKey;
        this.balance = saldo;
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

    @Override
    public String toString() {
        return "Titular: " + getHolder()
                + "\nChave Pix: " + getPixKey()
                + "\nSaldo: " + getBalance();
    }

}
