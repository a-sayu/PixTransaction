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
    // possivel criar contas duplicadas, add ja returna true entao contains desnecessario

    public boolean addAccount(Account account) {
        if (accounts.add(account)) {
            log.log(logType.INFO, "Conta n." + account.getNumeroConta()
                    + " foi adicionada ao catalogo ");
            return true;
        }
        log.log(logType.ERROR, "Conta n." + account.getNumeroConta()
                + " não foi adicionada ao catalogo ");
        return false;
    }

    public boolean removeAccount(Account account) {
        if (accounts.remove(account)) {
            log.log(logType.WARN, "Conta n." + account.getNumeroConta()
                    + " foi removida do catalogo ");
            return true;
        }
        log.log(logType.ERROR, "Conta n." + account.getNumeroConta()
                + " não foi removida ao catalogo ");
        return false;
    }

    public Account findAccountByChavePix(String chavePix) {
        for (Account account : accounts) {
            if (account.getChavePix().equals(chavePix)) {
                log.log(logType.INFO, "Conta n." + account.getNumeroConta()
                        + " foi encontrado no catalogo ");
                return account;
            }
        }
        log.log(logType.WARN, "Conta com chave Pix " + chavePix
                + " não foi encontrado no catalogo ");
        return null;
    }

    public void printAccount(String chavePix) {
        Account account = findAccountByChavePix(chavePix);
        System.out.println("\n\nCONTA =======================");
        System.out.println(account);
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println("\n\nCONTA =======================");
            System.out.println(account);
        }
    }

}
