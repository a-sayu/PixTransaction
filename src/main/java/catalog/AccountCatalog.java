package catalog;

import java.util.ArrayList;
import model.Account;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class AccountCatalog {
    
    private ArrayList<Account> accounts;
    
    public AccountCatalog() {
        accounts = new ArrayList<>();
    }
    
    public boolean addAccount(Account account) {
        accounts.add(account);
        return accounts.contains(account);
    }
    
    public boolean removeAccount(Account account) {
        accounts.remove(account);
        return !accounts.contains(account);
    }
    
    public Account findAccountPorChavePix(String chavePix) {
        for (Account account : accounts) {
            if (account.getChavePix().equals(chavePix)) return account;
        }
        return null;
    }
    
    public Account findAccountPorNumeroConta(int numeroConta) {
        for (Account account : accounts) {
            if (account.getNumeroConta() == numeroConta) return account;
        }
        return null;
    }
    
}
