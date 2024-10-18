
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
        this.saldo=0.0f;
    }
    public float consultarSaldo(){
        return saldo;
    }
        
    public float consultarLimite(){
      return limite; 
    } 
    
    public boolean realizarTransacao(float valor){
        if(valor <= limite-saldo){
            saldo += valor;
            return true;
        } 
        return false;
            
    }
}
