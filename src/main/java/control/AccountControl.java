package control;

import catalog.AccountCatalog;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class AccountControl {

    private AccountCatalog catalog;

    public AccountControl() {
        catalog = new AccountCatalog();
    }

    public String connectAccount(String numeroConta) {
        Account account = catalog.findAccountPorNumeroConta(Integer.parseInt(numeroConta));
        return Integer.toString(account.getNumeroConta());
    }

}
