package control;

import log.Logger;
import log.logType;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class PixControl {

    private Logger log;

    public PixControl() {
        log = Logger.getInstance();
    }

    public boolean transactionByPix(Account a, Account b, Double value) {
        if (a.debitSaldo(value)) {
            b.creditSaldo(value);
            log.log(logType.INFO, "Um Pix de R$ " + value
                    + " foi feito para " + b.getTitular()
                    + " de " + a.getTitular());
            return true;
        }
        log.log(logType.ERROR, "Um Pix de R$ " + value
                + " nao foi realizado para " + b.getTitular()
                + ", o valor eh superior ao saldo de " + a.getTitular());
        return false;
    }

}
