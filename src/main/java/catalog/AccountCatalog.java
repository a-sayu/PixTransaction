package catalog;

import log.Logger;
import log.logType;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class AccountCatalog {

    private ArrayList<Account> accounts;
    private Logger log;

    public AccountCatalog() {
        log = Logger.getInstance();
        accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) {
        accounts.add(account);
        log.log(logType.INFO, "Conta n." + account.getNumeroConta() + " foi adicionado ao catalogo ");
        return accounts.contains(account);
    }

    public boolean removeAccount(Account account) {
        accounts.remove(account);
        log.log(logType.WARN, "Conta n." + account.getNumeroConta() + " foi removido do catalogo ");
        return !accounts.contains(account);
    }

    public Account findAccountByChavePix(String chavePix) {
        for (Account account : accounts) {
            if (account.getChavePix().equals(chavePix)) {
                log.log(logType.INFO, "Conta n." + account.getNumeroConta() + " foi encontrado no catalogo ");
                return account;
            }
        }
        return null;
    }

    public Account findAccountByNumeroConta(int numeroConta) {
        for (Account account : accounts) {
            if (account.getNumeroConta() == numeroConta) {
                log.log(logType.INFO, "Conta n." + account.getNumeroConta() + " foi encontrado no catalogo ");
                return account;
            }
        }
        return null;
    }

}
