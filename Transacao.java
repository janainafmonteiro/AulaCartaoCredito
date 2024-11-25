
package IntroducaoPOO;



public class Transacao {
    private String data;
    private float valor;
    private String descricao;
    
    public Transacao(String data, float valor, String descricao){
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String imprimirHistorico(Transacao transacao){
        return "Data: " + data + "  Valor: " + valor + "  Descricao: " + descricao;
        
    }

}
