package model;

import java.time.LocalDateTime;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Pix {

    private double value;
    private String pixKey;
    private Type pixType;
    private LocalDateTime paymentDate;

    public enum Type {
        PAYER,
        PAYEE
    }

    public Pix(String pixKey, double Value, Type pixType) {
        this.pixKey = pixKey;
        this.value = Value;
        this.pixType = pixType;
        this.paymentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String label = getType() == Type.PAYEE ? "Pagador" : "Recebedor";

        return "Data do Pix: " + getPaymentDate()
                + "\nChave Pix do " + label + ": " + getPixKey()
                + "\nValor do Pix: " + getValue();

    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPixKey() {
        return pixKey;
    }

    public Type getType() {
        return pixType;
    }

}
