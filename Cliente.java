
package IntroducaoPOO;

public class Cliente {
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private String telefone;

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getCpf(){
        return this.cpf;
    }  
    public void setCpf(String cpf){
        this.cpf = cpf;
    } 
    public String getCnpj(){
        return this.cnpj;
    }  
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    } 
    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
