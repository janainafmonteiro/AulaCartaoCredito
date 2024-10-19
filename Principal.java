
package IntroducaoPOO;

import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Verificador verif = new Verificador();
        System.out.println("Escreva suas informações");
        String numero, nomeTitular, cpfTitular;
        float limite;   
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
