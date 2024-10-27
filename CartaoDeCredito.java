
package IntroducaoPOO;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;
    private float taxaCashback;
    private float cashback=0;
    private List<Float> valorCompra = new ArrayList<>();
    private List<String> nomeCompra = new ArrayList<>();
    
    public CartaoDeCredito(){
    }
    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite){
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo=limite;
    }
    public void inicializarSaldo(){
        this.saldo= this.limite;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public String getNomeTitular(){
        return this.nomeTitular;
    }
    public void setNomeTitular(String nome){
        this.nomeTitular=nome;
    }
    public String getCpfTitular(){
        return this.cpfTitular;
    }  
    public void setCpfTitular(String cpf){
        this.cpfTitular = cpf;
    } 
    public float getSaldo(){
        return this.saldo;
    }   
    public void setSaldo(float saldo){
       this.saldo = saldo;
    }
    public float getLimite(){
      return this.limite; 
    } 
    public void setLimite(float limite){
      this.limite = limite; 
    } 
    public void imprimirFatura(){
        float valorFatura = getLimite()-getSaldo();
        System.out.println("Sua fatura está em: R$" + valorFatura);
        for(int i=0; i<valorCompra.size();i++){
            System.out.println(nomeCompra.get(i) + " = R$" + valorCompra.get(i));
        }
    }
     public void setCategoriaCompra(String categoria){
        this.nomeCompra.add(categoria);
    }
     public void setValorCompra(float valorCompra){
        this.valorCompra.add(valorCompra);
    }

    public boolean realizarTransacao(float valor){
         if(valor<=this.saldo){
            this.saldo -= valor;
            return true;
        }
         return false;
    }
    public boolean realizarTransacao(float valor, float taxaCashback){
         if(valor<=this.saldo){
            this.saldo -= valor;
            setCashback((taxaCashback/100)*valor);
            return true;
        }
         return false;
    }
 
    public void aumentarLimite(){
        this.limite += 100;
        this.saldo += 100;
        System.out.println("Parabéns por ser um cliente fiel, seu limite será aumentado!");        
    }

    public float getCashback() {
        return cashback;
    }

    public void setCashback(float cashback) {
        this.cashback = cashback;
    }
}
