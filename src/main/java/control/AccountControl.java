package control;

import log.Logger;
import log.logType;
import catalog.AccountCatalog;
import java.util.ArrayList;
import java.util.List;
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

    public Account searchAccountByNumeroConta(String numeroConta) {
        Account account = catalog.findAccountByNumeroConta(Integer.parseInt(numeroConta));
        return account;
    }
    
    public Account searchAccountByChavePix(String chavePix) {
        Account account = catalog.findAccountByChavePix(chavePix);
        return account;
    }

    public boolean registerAccount(ArrayList<String> accountData) {
        Account account = new Account(Integer.parseInt(accountData.get(1)), accountData.get(0), accountData.get(2), Double.parseDouble(accountData.get(3)));
        log.log(logType.INFO, "Conta n." + account.getNumeroConta() + " - " + account.getTitular() + " de chave Pix:  " + account.getChavePix() + " com saldo de R$ " + account.getSaldo() + " foi criada.");
        return catalog.addAccount(account);
    }
    
    public ArrayList<String> returnAccountData(String numeroConta) {
        Account account = searchAccountByNumeroConta(numeroConta);
        ArrayList<String> accountData = new ArrayList<>();
        accountData.addAll(List.of(account.getTitular(), String.valueOf(account.getNumeroConta()), account.getChavePix(), String.valueOf(account.getSaldo())));
        return accountData;
    }

}
