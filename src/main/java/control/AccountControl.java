package control;

import log.Logger;
import log.logType;
import catalog.AccountCatalog;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class AccountControl {

    private final AccountCatalog catalog;
    private Logger log;

    public AccountControl() {
        catalog = new AccountCatalog();
        log = Logger.getInstance();
    }

    public Account searchAccountByChavePix(String chavePix) {
        Account account = catalog.findAccountByChavePix(chavePix);
        return account;
    }

    public boolean registerAccount(String titular, int numeroConta, String chavePix, double saldo) {
        Account account = new Account(titular, numeroConta, chavePix, saldo);
        log.log(logType.INFO, "Conta do titular " + account.getTitular()
                + ", chave pix: " + account.getChavePix()
                + " com saldo de R$ " + account.getSaldo()
                + "foi criada.");
        return catalog.addAccount(account);
    }

    public void showAccount(String chavePix) {
        catalog.printAccount(chavePix);
    }
    
    public void showAllAccounts() {
        catalog.printAllAccounts();
    }

}
