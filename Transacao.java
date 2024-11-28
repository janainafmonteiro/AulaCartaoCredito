
package IntroducaoPOO;

import java.util.Date;



public class Transacao {
    private Date data;
    private float valor;
    private String descricao;
    
    public Transacao(Date data, float valor, String descricao){
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String imprimirHistorico(Transacao transacao){
        return "Data: " + data + "  Valor: " + valor + "  Descricao: " + descricao;
        
    }

}
