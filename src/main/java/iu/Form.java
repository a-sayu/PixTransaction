package iu;

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

    public int initialForm() {
        System.out.println("= BANCO CONFIAVEL ==========\n");
        System.out.println("1. Criar Conta");
        System.out.println("2. Conectar Conta");
        System.out.println("3. Realizar um Pix");
        System.out.println("4. Visualizar Sua Conta");
        System.out.println("5. Visualizar Todas as Contas");
        System.out.println("0. Sair");
        return Integer.parseInt(scanInput.nextLine());
    }

    public String getChavePix(String prefix) {
        System.out.println("= " + prefix + " ==========\n");
        System.out.print("Digite chave Pix: ");
        return scanInput.nextLine();
    }

    public double getValue() {
        System.out.print("Digite valor a Pagar: ");
        return Double.parseDouble(scanInput.nextLine());
    }

    public String registerForm(String tipoRetorno) {
        if (tipoRetorno.equalsIgnoreCase("titular")) {
            System.out.print("Nome do Titular: ");
        }
        if (tipoRetorno.equalsIgnoreCase("chavePix")) {
            System.out.print("Chave Pix: ");
        }
        return scanInput.nextLine();
    }

    public int registerForm(String tipoRetorno) {
        System.out.print("Número da Conta: ");
        return Integer.parseInt(scanInput.nextLine());
    }

    public double registerForm(String tipoRetorno) {
        System.out.println("Saldo: ");
        return Double.parseDouble(scanInput.nextLine());
    }
}
