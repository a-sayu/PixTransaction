package control;

import catalog.PixCatalog;
import model.Account;
import model.Pix;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class PixControl {

    private final PixCatalog catalog;

    public PixControl() {
        catalog = new PixCatalog();
    }

    public boolean transactionByPix(Account payer, Account payee, double value) {
        Pix pix = new Pix(value, payer, payee);
        return catalog.addPix(pix);
    }

    public void showAllPixTransactions() {
        catalog.showAllPayments();
    }

    public void showPixExtract(Account account) {
        catalog.showAllPaymentsFromAccount(account);
    }

}
