package iu;

import control.AccountControl;
import java.util.Scanner;
import log.Logger;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Form {

    private Scanner scanInput;
    private AccountControl accountControl;
    private Logger log;

    public Form() {
        scanInput = new Scanner(System.in);
    }

    public int choiceForm() {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("1. Criar Conta");
        System.out.println("2. Conectar Conta");
        System.out.println("3. Realizar um Pix");
        System.out.println("4. Visualizar Sua Conta");
        System.out.println("5. Visualizar Seu Extrato");
        System.out.println("6. Visualizar Log");
        System.out.println("0. Sair");
        return Integer.parseInt(scanInput.nextLine());
    }

    public boolean initializeAtt() {
        log = Logger.getInstance();
        accountControl = new AccountControl();
        return true;
    }

    public boolean initializeApp() {
        int option;
        String connected = "";
        do {
            option = choiceForm();

            switch (option) {
                case 1 -> {
                    createAccount();
                }
                case 2 -> {
                    connected = selectAccount();
                }
                case 3 -> {
                    if (!connected.isBlank()) {
                        pixTransaction(connected);
                    } else {
                        notConnected();
                    }
                }
                case 4 -> {
                    if (!connected.isBlank()) {
                        returnBalance(connected);
                    } else {
                        notConnected();
                    }
                }
                case 5 -> {
                    if (!connected.isBlank()) {
                        returnPixTransactionExtract(connected);
                    } else {
                        notConnected();
                    }
                }
                case 6 -> {
                    log.showLog();
                }
                case 0 -> {
                    leave();
                }
            }
        } while (option != 0);
        return true;
    }

    public boolean createAccount() {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("= Cadastro =================\n");
        System.out.print("Titular: ");
        String holder = scanInput.nextLine();
        System.out.print("Chave Pix: ");
        String pixKey = scanInput.nextLine();
        System.out.print("Saldo (Exemplo: 1.0): ");
        double balance = Double.parseDouble(scanInput.nextLine());
        return accountControl.registerAccount(holder, pixKey, balance);
    }

    public String selectAccount() {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("= Login ====================\n");
        System.out.print("Digite sua chave Pix: ");
        return scanInput.nextLine();
    }

    public boolean pixTransaction(String connected) {
        String pixKey;
        double pixValue;
        if (accountControl.searchAccountByPixKey(connected) == null) {
            return false;
        }
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("= PIX ======================\n");
        System.out.print("Digite a chave Pix de quem voce ira transferir para: ");
        pixKey = scanInput.nextLine();
        System.out.print("Digite o valor a ser transferido: ");
        pixValue = Double.parseDouble(scanInput.nextLine());
        return accountControl.transactionByPix(connected, pixKey, pixValue);
    }

    public boolean returnBalance(String connected) {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("= SALDO ====================\n");
        accountControl.showAccount(connected);
        return true;
    }

    public void leave() {
        System.out.println("Ate mais!");
    }

    public boolean notConnected() {
        System.out.println("Voce nao esta conectado");
        System.out.println("Conecte uma conta valida");
        return true;
    }

    private boolean returnPixTransactionExtract(String connected) {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("= SALDO ====================\n");
        accountControl.showPixExtract(connected);
        return true;
    }
}
