
package IntroducaoPOO;

public class CartaoDeCredito {
    String numero;
    String nomeTitular;
    String cpfTitular;
    float limite;
    float saldo;
    
    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite){
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo=limite;
    }
    public float consultarSaldo(){
        return this.saldo;
    }
        
    public float consultarLimite(){
      return this.limite; 
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
