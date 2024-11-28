
package IntroducaoPOO;


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Principal{
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        System.out.println("Escreva suas informações");
        
        String nomeTitular, cpfTitular = null, cnpjTitular = null, emailTitular, telefone;
        float limite=0, economizado=0;   
        int op, contador=0, beneficio, numero;
        
        System.out.println("Escreva seu nome: ");
        nomeTitular = entrada.nextLine();
        
        System.out.println("Escreva seu número: ");
        numero = entrada.nextInt();
        
        entrada.nextLine();
        
        System.out.println("Escreva seu telefone: ");
        telefone = entrada.nextLine();

        
        System.out.println("Escreva seu email: ");
        emailTitular = entrada.nextLine();
        
        System.out.println("1 para cpf e 2 para cnpj");
        op = entrada.nextInt();
        entrada.nextLine();
        switch(op){
            case 1:
                System.out.println("Escreva seu cpf: ");
                cpfTitular = entrada.nextLine();
                break;
            case 2:
                System.out.println("Escreva seu cnpj: ");
                cnpjTitular = entrada.nextLine();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        Cliente cliente = new Cliente();
        
        cliente.setNome(nomeTitular);
        cliente.setCpf(cpfTitular);
        cliente.setCnpj(cnpjTitular);
        cliente.setTelefone(telefone);
        cliente.setEmail(emailTitular);
        CartaoDeCredito cartao;
        do{
            System.out.println("Escolha o seu cartão?\n1.Cartão Basico\n2.Cartão Premium\n3.Cartão Empresarial");
            beneficio = entrada.nextInt();
            switch(beneficio){
                case 1: 
                    limite = aleatorio.nextFloat(50, 2000);  
                    cartao = new CartaoBasico(numero, limite, cliente);
                    break;
                case 2:
                    limite = aleatorio.nextFloat(2000, 5000);
                    cartao = new CartaoPremium(numero, limite, cliente);
                    break;
                case 3:
                    limite = aleatorio.nextFloat(5000, 10000);
                    cartao = new CartaoEmpresarial(numero, limite, cliente);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    cartao = new CartaoDeCredito();
                    break;
            }
        }while(limite==0);      
        
        
        
        
        
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
                if(beneficio==3){
                    System.out.println("Qual o numero de parcelas?");
                    int parcela = entrada.nextInt();
                    if(cartao.realizarTransacao(valor, parcela)){
                        System.out.println("Transação realizada com sucesso");
                        contador++;
                    }else{
                    System.out.println("Saldo insuficiente");
                    }
                }else{
                    if(cartao.realizarTransacao(valor)){
                        System.out.println("Transação realizada com sucesso");
                        contador++;
                        if(beneficio == 2){
                            economizado += cartao.getCashback();
                            System.out.println("Economizado nessa compra: " + cartao.getCashback());
                        }
                    }else{
                    System.out.println("Saldo insuficiente");
                    }
                }
                

                 cartao.setHistorico(new Date(), valor, categoria);
                if(contador==10 && beneficio==2){
                    cartao.aumentarLimite();
                    contador=0;
                }else if(contador==15 && beneficio==1){
                    cartao.aumentarLimite();
                    contador=0;
                }else if(contador==20 && beneficio==3){
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
                if(beneficio==2){
                    System.out.println("Você possui R$"+ economizado + " de cashback para resgatar");
                }
                cartao.getHistorico();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
       }
        }while(op!=-1); 
            
    }
        
}
