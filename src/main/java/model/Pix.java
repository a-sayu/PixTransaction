
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Pix {
    private double value;
    private Account payer;
    private Account payee;
    private LocalDateTime paymentDate;

    public Pix(double Value, Account Payer, Account Payee) {
        this.value = Value;
        this.payer = Payer;
        this.payee = Payee;
        this.paymentDate = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Data do Pix: " + getPaymentDate()
                + "\nPagador: " + getPayer().getHolder()
                + "\nRecebedor: " + getPayee().getHolder()
                + "\nChave Pix: " + getPayee().getPixKey()
                + "\nValor do Pix: " + getValue();
    }

    public double getValue() {
        return value;
    }

    public Account getPayer() {
        return payer;
    }

    public Account getPayee() {
        return payee;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    
    
}
