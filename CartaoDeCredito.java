
import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private String numero;
    private float limite;
    private float saldo;
    private float taxaCashback;
    private float cashback=0;
    private List<Float> valorCompra = new ArrayList<>();
    private List<String> nomeCompra = new ArrayList<>();
    
    public CartaoDeCredito(){
    }
    public CartaoDeCredito(String numero, float limite){
        this.numero = numero;
        this.limite = limite;
        this.saldo=limite;
    }
    public void inicializarSaldo(){
        this.saldo= this.limite;
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
