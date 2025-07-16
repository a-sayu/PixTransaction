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
            log.log(logType.INFO, "Um Pix de R$ " + value + " foi feito de " + a.getTitular() + " para " + b.getTitular());
            return true;
        }
        log.log(logType.WARN, "Um Pix de R$ " + value + " nao foi realizado para " + b.getTitular() + " o valor eh superior ao saldo de " + a.getTitular());
        return false;
    }

}
