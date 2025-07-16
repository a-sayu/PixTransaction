package iu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class Form {

    private Scanner scanInput;

    public Form() {
        scanInput = new Scanner(System.in);

    }

    public ArrayList<String> pixForm() {
        ArrayList<String> inputContent = new ArrayList<>();

        System.out.print("Chave Pix: ");
        inputContent.add(scanInput.nextLine());
        System.out.print("Valor: ");
        inputContent.add(scanInput.nextLine());

        return inputContent;
    }

    public void showAccount(ArrayList<String> info) {
        System.out.println("\n\nCONTA =======================");
        System.out.println("Nome do Titular: " + info.get(0));
        System.out.println("Numero da Conta: " + info.get(1));
        System.out.println("Chave Pix: " + info.get(2));
        System.out.println("Saldo: " + info.get(3));
    }

    public String connectForm() {
        String numberAccount;

        System.out.print("Número da Sua Conta: ");
        numberAccount = scanInput.nextLine();

        return numberAccount;
    }

    public ArrayList<String> registerForm() {
        ArrayList<String> inputContent = new ArrayList<>();

        System.out.print("Nome do Titular: ");
        inputContent.add(scanInput.nextLine());
        System.out.print("Número da Conta: ");
        inputContent.add(scanInput.nextLine());
        System.out.print("Chave Pix: ");
        inputContent.add(scanInput.nextLine());
        System.out.print("Saldo: ");
        inputContent.add(scanInput.nextLine());

        return inputContent;
    }

    public int initialForm() {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("1. Criar/Conectar Conta");
        System.out.println("2. Realizar um Pix");
        System.out.println("3. Visualizar Conta");
        System.out.println("0. Sair");
        return Integer.parseInt(scanInput.nextLine());
    }

}
