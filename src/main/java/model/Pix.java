package model;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Pix {

    public Pix() {

    }

    public boolean transaction(Account a, Account b, Double value) {
        if (a.debitSaldo(value)) {
            b.creditSaldo(value);
            return true;
        }
        return false;
    }
}
