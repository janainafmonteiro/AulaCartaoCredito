
package IntroducaoPOO;

public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;
    
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
    public void setSaldo(float valor){
        if(valor<=this.saldo){
            this.saldo -= valor;
            System.out.println("Transação realizada com sucesso");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    public float getLimite(){
      return this.limite; 
    } 
    public void setLimite(float limite){
      this.limite = limite; 
    } 
    
    public void realizarTransacao(float valor){
        if(valor<=this.saldo){
            this.saldo -= valor;
            System.out.println("Transação realizada com sucesso");
        } else{
            System.out.println("Limite insuficiente");
        }
            
    }
}
