package model;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Account {

    private int numeroConta;
    private String titular;
    private String chavePix;
    private double saldo;

    public Account(int numeroConta, String titular, String chavePix, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.chavePix = chavePix;
        this.saldo = saldo;
    }

    public boolean creditSaldo(double value) {
        saldo += value;
        return true;
    }

    public boolean debitSaldo(double value) {
        if (value > saldo) {
            return false;
        }
        saldo -= value;
        return true;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public String getChavePix() {
        return chavePix;
    }

    public double getSaldo() {
        return saldo;
    }

}
