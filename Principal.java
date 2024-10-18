
package IntroducaoPOO;

import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escreva suas informações");
        String numero, nomeTitular, cpfTitular;
        float limite, saldo;    
        System.out.println("Escreva seu número: ");
        numero = entrada.nextLine();
        System.out.println("Escreva seu nome: ");
        nomeTitular = entrada.nextLine();
        System.out.println("Escreva seu cpf: ");
        cpfTitular = entrada.nextLine();
        System.out.println("Escreva seu limite: ");
        limite = entrada.nextFloat();
        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);
        System.out.println("O que deseja fazer: \n1. Realizar Transação\n2.Consultar Limite\n3.Consultar Saldo");
        int op = entrada.nextInt();
        switch(op){
            case 1: 
        }
            
    }
        
}
