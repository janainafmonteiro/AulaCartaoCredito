
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
        CartaoDeCredito cartao = new CartaoDeCredito();
        cartao.setNumero(numero);
        cartao.setNomeTitular(nomeTitular);
        cartao.setCpfTitular(cpfTitular);
        cartao.setLimite(limite);
        cartao.inicializarSaldo();
       do{
            
        System.out.println("O que deseja fazer: \n1. Realizar Transação\n2.Consultar Limite\n3.Consultar Saldo\n4.Alterar Limite");
        op = entrada.nextInt();
        switch(op){
            case 1: 
                System.out.println("Qual valor da transação?");
                float valor = entrada.nextFloat();
                cartao.setSaldo(valor);
                break;
            case 2:           
                System.out.println(cartao.getLimite());
                break;
            case 3:               
                System.out.println(cartao.getSaldo());
                break;
            case 4:
                System.out.println("Escreva seu limite: ");
                limite = entrada.nextFloat();
                cartao.setLimite(limite);
                System.out.println("Limite alterado com sucesso!");
            default:
                break;
       }
        }while(op!=-1); 
            
    }
        
}
