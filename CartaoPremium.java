
package IntroducaoPOO;


public class CartaoPremium extends CartaoDeCredito {
    public CartaoPremium(int numero, float limite, Cliente titular){
        super(numero, limite, titular);
    }
        
    @Override
    public boolean realizarTransacao(float valor){
     if(valor<=this.saldo){
        this.saldo -= valor;
        setCashback((cashback/100)*valor);
        return true;
    }
     return false;
    }
}
