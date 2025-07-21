package app;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class App {

//    private final Form form;
//    private final AccountControl accountControl;
//    private final PixControl pixControl;
//    private Logger log;
//
//    public App() {
//        log = Logger.getInstance();
//        form = new Form(); // controladores são criados e usados no form!
//        accountControl = new AccountControl(); // o controlador que analisa todo o resto depois "dali para baixo"
//        pixControl = new PixControl();
//    }
//
//    public void run() {
//        String payerChavePix = "";
//        int option;
//        do {
//            option = form.choiceForm();
//            switch (option) {
//                case 1 -> {
//                    String titular = form.registerTitular();
//                    int numeroConta = form.registerNumeroConta();
//                    String chavePix = form.registerChavePix();
//                    double saldo = form.registerSaldo();
//                    registerAccount(titular, numeroConta, chavePix, saldo);
//                }
//                case 2 -> {
//                    payerChavePix = setChavePix("Sua Chave Pix");
//                }
//                case 3 -> {
//                    transaction(payerChavePix);
//                }
//                case 4 -> {
//                    showAccount(payerChavePix);
//                }
//                case 5 -> {
//                    showAllAccounts();
//                }
//            }
//        } while (option != 0);
//        transaction(payerChavePix);
//
//        showAllAccounts();
//
//        log.showLog();
//    }
//
//    public void runDebug() {
//        String payerChavePix;
//        String receiverChavePix;
//        double valueToPay;
//
//        registerAccount("SANDRO", 1, "sandro@gmail.com", 25000.0);
//        registerAccount("ALICE", 2, "18999999999", 200.0);
//        registerAccount("ANTONIO", 3, "antonio@hotmail.com", 1500.0);
//
//        payerChavePix = setChavePixDebug("sandro@gmail.com");
//        receiverChavePix = setChavePixDebug("18999999999");
//
//        showAccount(payerChavePix);
//        showAccount(receiverChavePix);
//
//        valueToPay = 200.0;
//        transactionDebug(payerChavePix, receiverChavePix, valueToPay);
//
//        valueToPay = 25000.0;
//        transactionDebug(payerChavePix, receiverChavePix, valueToPay);
//
//        valueToPay = 2500.0;
//        transactionDebug(payerChavePix, receiverChavePix, valueToPay);
//
//        log.showLog();
//        
//        payerChavePix = setChavePix("Sua Chave Pix");
//        transaction(payerChavePix);
//        showAllAccounts();
//        log.showLog();
//    }
//
//    private String setChavePixDebug(String chavePix) {
//        return chavePix;
//    }
//
//    private String setChavePix(String prefix) {
//        return form.getChavePix(prefix);
//    }
//
//    private double setValueToPay() {
//        return form.getValue();
//    }
//
//    private void transactionDebug(String chavePixToPay, String chavePixToReceive, double valueToPay) {
//        pixControl.transactionByPix(accountControl.searchAccountByChavePix(chavePixToPay), accountControl.searchAccountByChavePix(chavePixToReceive), valueToPay);
//    }
//
//    private void transaction(String chavePixToPay) {
//        String chavePixToReceive = setChavePix("Chave Pix a Pagar");
//        double valueToPay = setValueToPay();
//        pixControl.transactionByPix(accountControl.searchAccountByChavePix(chavePixToPay), accountControl.searchAccountByChavePix(chavePixToReceive), valueToPay);
//    }
//
//    private void registerAccount(String titular, int numeroConta, String chavePix, double saldo) {
//        accountControl.registerAccount(titular, numeroConta, chavePix, saldo);
//    }
//
//    private void showAccount(String chavePix) {
//        accountControl.showAccount(chavePix);
//    }
//
//    private void showAllAccounts() {
//        accountControl.showAllAccounts();
//    }
    
}