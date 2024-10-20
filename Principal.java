
package IntroducaoPOO;

import java.util.Random;
import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Verificador verif = new Verificador();
        Random aleatorio = new Random();
        System.out.println("Escreva suas informações");
        String numero, nomeTitular, cpfTitular;
        float limite=0;   
        int op;
        System.out.println("Escreva seu número: ");
        numero = entrada.nextLine();
        System.out.println("Escreva seu nome: ");
        do{
            nomeTitular = entrada.nextLine();
            if(!verif.validarNome(nomeTitular)){
                System.out.println("Nome inválido, escreva novamente:");
            }
        }while(!verif.validarNome(nomeTitular));
        System.out.println("Escreva seu cpf: ");
        do{
            cpfTitular = entrada.nextLine();
            if(!verif.validarCpf(cpfTitular)){
                System.out.println("CPF inválido, escreva novamente:");
            }
        }while(!verif.validarCpf(cpfTitular));       
        do{
            System.out.println("Para que você quer seu cartão?\n1.Cartão com limite menor e poucos beneficios\n2.Cartão com limite maior e muitos beneficios");
            op = entrada.nextInt();
            switch(op){
                case 1: 
                    limite = aleatorio.nextFloat(50, 2000);
                    break;
                case 2:
                    limite = aleatorio.nextFloat(2000, 10000);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(limite==0);           
        CartaoDeCredito cartao = new CartaoDeCredito();
        cartao.setNumero(numero);
        cartao.setNomeTitular(nomeTitular);
        cartao.setCpfTitular(cpfTitular);
        cartao.setLimite(limite);
        cartao.inicializarSaldo();
       do{
            
        System.out.println("O que deseja fazer: \n1. Realizar Transação\n2.Consultar Limite\n3.Consultar Saldo");
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
            default:
                System.out.println("Opção inválida!");
                break;
       }
        }while(op!=-1); 
            
    }
        
}
