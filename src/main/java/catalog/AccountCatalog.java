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
        if (findAccountByPixKey(account.getPixKey()) == null) {
            if (accounts.add(account)) {
                log.log(logType.INFO, "Conta com titular: " + account.getHolder()
                        + ", chave pix: " + account.getPixKey()
                        + " e saldo de R$ " + account.getBalance()
                        + " foi criada e adicionada ao catalgo.");
                return true;
            }
            log.log(logType.ERROR, "Conta com chave Pix:" + account.getPixKey()
                    + " não foi adicionada ao catalogo");
        } else {
            log.log(logType.WARN, "Conta com chave Pix:" + account.getPixKey() + " já existe no catalogo");
        }
        return false;
    }

    public boolean removeAccount(Account account) {
        if (accounts.remove(account)) {
            log.log(logType.WARN, "Conta com chave Pix:" + account.getPixKey()
                    + " foi removida do catalogo ");
            return true;
        }
        log.log(logType.ERROR, "Conta com chave Pix:" + account.getPixKey()
                + " não foi removida ao catalogo ");
        return false;
    }

    public Account findAccountByPixKey(String pixKey) {
        for (Account account : accounts) {
            if (account.getPixKey().equals(pixKey)) {
                log.log(logType.INFO, "Conta com chave Pix:" + account.getPixKey()
                        + " foi encontrado no catalogo ");
                return account;
            }
        }
        log.log(logType.ERROR, "Conta com chave Pix: " + pixKey
                + " não foi encontrado no catalogo ");
        return null;
    }

    public void printAccount(String pixKey) {
        Account account = findAccountByPixKey(pixKey);
        System.out.println("\n\nCONTA =======================");
        System.out.println(account);
    }

    public boolean addPix(String payerKey, String payeeKey, double value) {
        Account payer = findAccountByPixKey(payerKey);
        Account payee = findAccountByPixKey(payeeKey);
        if (payee == null || payer == null) {
            return false;
        }
        if (payer.addPixAsPayer(payeeKey, value)) {
            return payee.addPixAsPayee(payerKey, value);
        }
        log.log(logType.ERROR, "Transferência PIX falhou. Não foi possível debitar R$ " + value
                + " da conta pagadora com chave: " + payerKey + ".");
        return false;
    }

    public void printAllPayments(String pixKey) {
        Account account = findAccountByPixKey(pixKey);
        System.out.println("\n\nCONTA =======================");
        System.out.println(account);
        account.printPayments();
    }

}
