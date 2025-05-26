package util;
import java.util.Scanner;

public class EntradaUsuario {
    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        int valor;
        try {
            valor = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Por favor, digite um número inteiro.");
            sc.nextLine(); 
            return lerInt(mensagem);
        }
        sc.nextLine(); 
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double valor;
        try {
            valor = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Por favor, digite um número decimal.");
            sc.nextLine(); 
            return lerDouble(mensagem); 
        }
        sc.nextLine(); 
        return valor;
    }


    public static Scanner getScanner() {
        return sc;
    }
}