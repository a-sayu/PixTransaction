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
        System.out.print("Nome do Titular: " + info.get(0));
        System.out.print("Número da Conta: " + info.get(1));
        System.out.print("Chave Pix: " + info.get(2));
        System.out.print("Saldo: " + info.get(3));
    }
    
    public String connectForm() {
        String numberAccount;
        
        System.out.print("Número da Sua Conta: ");
        numberAccount = scanInput.nextLine();
        
        return numberAccount;
    }

}
