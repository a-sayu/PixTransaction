package model;

import log.Logger;
import log.logType;

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

    public Account(String titular, int numeroConta, String chavePix, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
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

    public String getTitular() {
        return titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getChavePix() {
        return chavePix;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Titular: " + getTitular()
                + "\nn. Conta: " + getNumeroConta()
                + "\nChave Pix: " + getChavePix()
                + "\nSaldo: " + getSaldo();
    }

}
