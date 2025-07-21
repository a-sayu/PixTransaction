package control;

import catalog.AccountCatalog;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class AccountControl {

    private final AccountCatalog catalog;

    public AccountControl() {
        catalog = new AccountCatalog();
    }

    public Account searchAccountByPixKey(String chavePix) {
        Account account = catalog.findAccountByPixKey(chavePix);
        return account;
    }

    public boolean registerAccount(String holder, String pixKey, double balance) {
        Account account = new Account(holder, pixKey, balance);
        return catalog.addAccount(account);
    }

    public void showAccount(String pixKey) {
        catalog.printAccount(pixKey);
    }

    public void showAllAccounts() {
        catalog.printAllAccounts();
    }
    
}
