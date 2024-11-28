package IntroducaoPOO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartaoDeCredito {
    private int numero;
    private float limite;
    float saldo;
    float cashback=2;
    float fatura;
    private Cliente titular;
    private List<Transacao> historico = new ArrayList<>();
     public CartaoDeCredito(){
    }
    public CartaoDeCredito(int numero, float limite, Cliente titular){
        this.numero = numero;
        this.limite = limite;
        this.saldo=limite;
        this.titular = titular;
        this.fatura = 0;
    }
    public void inicializarSaldo(){
        this.saldo= this.limite;
    }
   public void getHistorico(){
        System.out.println("Sua fatura está em: R$" + fatura);
       for(int i = 0; i < historico.size(); i++){
           System.out.println(historico.get(i).imprimirHistorico(historico.get(i)));
       }
   }
   public void setHistorico(Date data, float valor, String descricao){
       Transacao transacao = new Transacao(data, valor, descricao);
       historico.add(transacao);
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
    public boolean realizarTransacao(float valor){
         if(valor<=this.saldo){
            this.fatura +=valor;
            this.saldo -= valor;
            return true;
        }
         return false;
    }
     public boolean realizarTransacao(float valor, int parcela){
         if(valor<=this.saldo){           
            this.saldo -= valor;
            valor /= parcela;
            this.fatura +=valor;
            
            return true;
        }
         return false;
    }

 
    public void aumentarLimite(){
        this.limite += 100;
        this.saldo += 100;
        System.out.println("Parabéns por ser um cliente fiel, seu limite será aumentado!");        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

public float getCashback() {
        return cashback;
    }

    public void setCashback(float cashback) {
        this.cashback = cashback;
    }
    

}
