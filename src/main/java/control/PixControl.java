package control;

import catalog.PixCatalog;
import log.Logger;
import log.logType;
import model.Account;
import model.Pix;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class PixControl {

    private Logger log;
    private final PixCatalog catalog;

    public PixControl() {
        log = Logger.getInstance();
        catalog = new PixCatalog();
    }

    public boolean transactionByPix(Account payer, Account payee, Double value) {
        if (payer.debitBalance(value)) {
            payee.creditBalance(value);
            Pix pix = new Pix(value, payer, payee);
            return catalog.addPix(pix);
        }
        log.log(logType.ERROR, "Um Pix de R$ " + value
                + " nao foi realizado para " + payee.getHolder()
                + ", o valor eh superior ao saldo de " + payer.getHolder());
        return false;
    }

}
