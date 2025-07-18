package app;

import log.Logger;
import iu.Form;
import control.AccountControl;
import control.PixControl;

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

    public App() {
        log = Logger.getInstance();
        form = new Form();
        accountControl = new AccountControl();
        pixControl = new PixControl();
    }

    public void run() {
        String payerChavePix = "";
        int option;
        do {
            option = form.initialForm();
            switch (option) {
                case 1 -> {
                    String titular = form.registerTitular();
                    int numeroConta = form.registerNumeroConta();
                    String chavePix = form.registerChavePix();
                    double saldo = form.registerSaldo();
                    registerAccount(titular, numeroConta, chavePix, saldo);
                }
                case 2 -> {
                    payerChavePix = setChavePix("Sua Chave Pix");
                }
                case 3 -> {
                    transaction(payerChavePix);
                }
                case 4 -> {
                    showAccount(payerChavePix);
                }
                case 5 -> {
                    showAllAccounts();
                }
            }
        } while (option != 0);
        transaction(payerChavePix);

        showAllAccounts();

        log.showLog();
    }

    public void runDebug() {
        String payerChavePix;
        String receiverChavePix;
        double valueToPay;

        registerAccount("SANDRO", 1, "sandro@gmail.com", 25000.0);
        registerAccount("ALICE", 2, "18999999999", 200.0);
        registerAccount("ANTONIO", 3, "antonio@hotmail.com", 1500.0);

        payerChavePix = setChavePixDebug("sandro@gmail.com");
        receiverChavePix = setChavePixDebug("18999999999");

        showAccount(payerChavePix);
        showAccount(receiverChavePix);

        valueToPay = 200.0;
        transactionDebug(payerChavePix, receiverChavePix, valueToPay);

        valueToPay = 25000.0;
        transactionDebug(payerChavePix, receiverChavePix, valueToPay);

        valueToPay = 2500.0;
        transactionDebug(payerChavePix, receiverChavePix, valueToPay);

        log.showLog();
        
        payerChavePix = setChavePix("Sua Chave Pix");
        transaction(payerChavePix);
        showAllAccounts();
        log.showLog();
    }

    private String setChavePixDebug(String chavePix) {
        return chavePix;
    }

    private String setChavePix(String prefix) {
        return form.getChavePix(prefix);
    }

    private double setValueToPay() {
        return form.getValue();
    }

    private void transactionDebug(String chavePixToPay, String chavePixToReceive, double valueToPay) {
        pixControl.transactionByPix(accountControl.searchAccountByChavePix(chavePixToPay), accountControl.searchAccountByChavePix(chavePixToReceive), valueToPay);
    }

    private void transaction(String chavePixToPay) {
        String chavePixToReceive = setChavePix("Chave Pix a Pagar");
        double valueToPay = setValueToPay();
        pixControl.transactionByPix(accountControl.searchAccountByChavePix(chavePixToPay), accountControl.searchAccountByChavePix(chavePixToReceive), valueToPay);
    }

    private void registerAccount(String titular, int numeroConta, String chavePix, double saldo) {
        accountControl.registerAccount(titular, numeroConta, chavePix, saldo);
    }

    private void showAccount(String chavePix) {
        accountControl.showAccount(chavePix);
    }

    private void showAllAccounts() {
        accountControl.showAllAccounts();
    }

//    public void run() {
//        int option;
//        do {
//            option = form.initialForm();
//            switch (option) {
//                case 1 -> {
//                    if (accountControl.registerAccount(form.registerForm())) {
//                        System.out.println("Nova Conta Registrada.");
//                    }
//                }
//                case 2 -> {
//                    if (pixPayment()) {
//                        System.out.println("Pagamento Realizado.");
//                        break;
//                    }
//                    System.out.println("Pagamento não Realizado.");
//                }
//                case 3 -> {
//                    if (accountConnect()) {
//                        form.showAccount(accountControl.returnAccountData(accountChavePix));
//                        break;
//                    }
//                    System.out.println("Informe ou registre sua conta primeiro.");
//                }
//                case 0 -> {
//                    System.out.println("Saindo...");
//                }
//            }
//        } while (option != 0);
//    }
//
//    public void runDebug() {
//        ArrayList<String> accountA = new ArrayList<>();
//        accountA.addAll(List.of("Sandro", "1", "sandro@gmail.com", "25000.0"));
//        ArrayList<String> accountB = new ArrayList<>();
//        accountB.addAll(List.of("Alice", "2", "18999999999", "100.0"));
//        accountControl.registerAccount(accountA);
//        accountControl.registerAccount(accountB);
//        form.showAccount(accountA);
//        form.showAccount(accountB);
//        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountA.get(1)), accountControl.searchAccountByChavePix(accountB.get(2)), 1000.0);
//        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountB.get(1)), accountControl.searchAccountByChavePix(accountA.get(2)), 1200.0);
//        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountA.get(1)), accountControl.searchAccountByChavePix(accountB.get(2)), 1000.0);
//        pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountB.get(1)), accountControl.searchAccountByChavePix(accountA.get(2)), 200.0);
//        log.showLog();
//        accountA.clear();
//        accountA = accountControl.returnAccountData("1");
//        accountB = accountControl.returnAccountData("2");
//        form.showAccount(accountA);
//        form.showAccount(accountB);
//    }
//
//    public boolean accountConnect() {
//        if (accountChavePix != null) {
//            return true;
//        }
//        accountChavePix = form.connectForm();
//        return accountControl.searchAccountByNumeroConta(accountChavePix) != null;
//    }
//
//    public boolean pixPayment() {
//        if (accountConnect()) {
//            ArrayList<String> pixData = form.pixForm();
//            if (pixControl.transactionByPix(accountControl.searchAccountByNumeroConta(accountChavePix), accountControl.searchAccountByChavePix(pixData.get(0)), Double.valueOf(pixData.get(1)))) {
//                return true;
//            }
//            System.out.println("Valor Inválido");
//            return false;
//        }
//        System.out.println("Informe ou registre sua conta primeiro.");
//        return false;
//    }
}
