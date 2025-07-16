package app;

import log.Logger;
import iu.Form;
import control.AccountControl;
import control.PixControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class App {

    private final Form form;
    private final AccountControl accountControl;
    private final PixControl pixControl;
    private Logger log;
    private String accountData;

    public App() {
        log = Logger.getInstance();
        form = new Form();
        accountControl = new AccountControl();
        pixControl = new PixControl();
    }

    public void run() {
        int option;
        do {
            option = form.initialForm();
            switch (option) {
                case 1 -> {
                    if (accountControl.registerAccount(form.registerForm())) {
                        System.out.println("Nova Conta Registrada.");
                    }
                }
                case 2 -> {
                    if (pixPayment()) {
                        System.out.println("Pagamento Realizado.");
                        break;
                    }
                    System.out.println("Pagamento não Realizado.");
                }
                case 3 -> {
                    if (accountConnect()) {
                        form.showAccount(accountControl.returnAccountData(accountData));
                        break;
                    }
                    System.out.println("Informe ou registre sua conta primeiro.");
                }
                case 0 -> {
                    System.out.println("Saindo...");
                }
            }
        } while (option != 0);
    }

    public void runDebug() {
        ArrayList<String> accountA = new ArrayList<>();
        accountA.addAll(List.of("Sandro", "1", "sandro@gmail.com", "25000.0"));
        ArrayList<String> accountB = new ArrayList<>();
        accountB.addAll(List.of("Alice", "2", "18999999999", "100.0"));
        accountControl.registerAccount(accountA);
        accountControl.registerAccount(accountB);
        form.showAccount(accountA);
        form.showAccount(accountB);
        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountA.get(1)), accountControl.searchAccountByChavePix(accountB.get(2)), 1000.0);
        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountB.get(1)), accountControl.searchAccountByChavePix(accountA.get(2)), 1200.0);
        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountA.get(1)), accountControl.searchAccountByChavePix(accountB.get(2)), 1000.0);
        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountB.get(1)), accountControl.searchAccountByChavePix(accountA.get(2)), 200.0);
        log.showLog();
        accountA.clear();
        accountA = accountControl.returnAccountData("1");
        accountB = accountControl.returnAccountData("2");
        form.showAccount(accountA);
        form.showAccount(accountB);
    }
    public boolean accountConnect() {
        if (accountData != null) {
            return true;
        }
        accountData = form.connectForm();
        return accountControl.searchAccountByNumeroConta(accountData) != null;
    }

    public boolean pixPayment() {
        if (accountConnect()) {
            ArrayList<String> pixData = form.pixForm();
            if (pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountData), accountControl.searchAccountByChavePix(pixData.get(0)), Double.valueOf(pixData.get(1)))) {
                return true;
            }
            System.out.println("Valor Inválido");
            return false;
        }
        System.out.println("Informe ou registre sua conta primeiro.");
        return false;
    }

}
