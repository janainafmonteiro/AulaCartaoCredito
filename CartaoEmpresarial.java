
package IntroducaoPOO;

public class CartaoEmpresarial extends CartaoDeCredito {
    private float faturaFutura;
    public CartaoEmpresarial(int numero, float limite, Cliente titular){  
        super(numero, limite, titular);
    }
    
    @Override
     public boolean realizarTransacao(float valor, int parcela){
         if(valor<=this.saldo){           
            this.saldo -= valor;
            if(parcela>1){
                valor /= parcela;               
                this.faturaFutura += valor*(parcela-1);
            }
            this.fatura +=valor;
            return true;
        }
         return false;
    }
     
      public void getHistorico(){
        System.out.println("Suas proximas faturas: " + faturaFutura);
        super.getHistorico();
   }
}
