
package IntroducaoPOO;

import java.util.Random;
import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        System.out.println("Escreva suas informações");
        
        String numero, nomeTitular, cpfTitular;
        float limite=0;   
        int op, contador=0, beneficio;
        
        System.out.println("Escreva seu número: ");
        numero = entrada.nextLine();
        
        System.out.println("Escreva seu nome: ");
        nomeTitular = entrada.nextLine();
        
        System.out.println("Escreva seu cpf: ");
        cpfTitular = entrada.nextLine();
 
        do{
            System.out.println("Para que você quer seu cartão?\n1.Cartão com limite menor e poucos beneficios\n2.Cartão com limite maior e muitos beneficios");
            beneficio = entrada.nextInt();
            switch(beneficio){
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
            
        System.out.println("O que deseja fazer: \n1. Realizar Transação\n2.Consultar Limite\n3.Consultar Saldo\n4.Consultar Fatura");
        op = entrada.nextInt();
        entrada.nextLine();
        switch(op){
            case 1: 
                System.out.println("Qual nome da compra?");
                String categoria = entrada.nextLine();
                System.out.println("Qual valor da transação?");
                float valor = entrada.nextFloat();
                if(cartao.setSaldo(valor)){
                    System.out.println("Transação realizada com sucesso");
                    cartao.setValorCompra(valor);
                    cartao.setCategoriaCompra(categoria);
                    contador++;
                }else{
                    System.out.println("Saldo insuficiente");
                }               
                if(contador==10 && beneficio==2){
                    cartao.aumentarLimite();
                    contador=0;
                }else if(contador==15 && beneficio==1){
                    cartao.aumentarLimite();
                    contador=0;
                }
                break;
            case 2:           
                System.out.println(cartao.getLimite());
                break;
            case 3:               
                System.out.println(cartao.getSaldo());
                break;
            case 4:             
                cartao.imprimirFatura();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
       }
        }while(op!=-1); 
            
    }
        
}
