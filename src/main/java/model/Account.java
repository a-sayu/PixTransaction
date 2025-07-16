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
    private Logger log;

    public Account(int numeroConta, String titular, String chavePix, double saldo) {
        log = Logger.getInstance();
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.chavePix = chavePix;
        this.saldo = saldo;
    }

    public boolean creditSaldo(double value) {
        saldo += value;
        log.log(logType.INFO, "R$ " + value + " foi adicionado ao saldo de " + getTitular());
        return true;
    }

    public boolean debitSaldo(double value) {
        if (value > saldo) {
            return false;
        }
        saldo -= value;
        log.log(logType.INFO, "R$ " + value + " foi removido do saldo de " + getTitular());
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
