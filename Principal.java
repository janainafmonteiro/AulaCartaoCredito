
package IntroducaoPOO;

import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escreva suas informações");
        String numero, nomeTitular, cpfTitular;
        float limite;   
        int op;
        System.out.println("Escreva seu número: ");
        numero = entrada.nextLine();
        System.out.println("Escreva seu nome: ");
        nomeTitular = entrada.nextLine();
        System.out.println("Escreva seu cpf: ");
        cpfTitular = entrada.nextLine();
        System.out.println("Escreva seu limite: ");
        limite = entrada.nextFloat();
        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);
       do{
            
        System.out.println("O que deseja fazer: \n1. Realizar Transação\n2.Consultar Limite\n3.Consultar Saldo");
        op = entrada.nextInt();
        switch(op){
            case 1: 
                System.out.println("Qual valor da transação?");
                float valor = entrada.nextFloat();
                cartao.realizarTransacao(valor);
                break;
            case 2:           
                System.out.println(cartao.consultarLimite());
                break;
            case 3:               
                System.out.println(cartao.consultarSaldo());
                break;
            default:
                break;
       }
        }while(op!=-1); 
            
    }
        
}
