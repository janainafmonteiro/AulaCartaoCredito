
package IntroducaoPOO;

public class Verificador {
    //verificar cpf
    public boolean validarCpf(String cpf){
        cpf = cpf.replaceAll("\\D", "");
        if(cpf.length()!=11){
            return false;
        }
        
        int[] digitos = new int[11];
        for (int i = 0; i<11; i++) {
           digitos[i]= Character.getNumericValue(cpf.charAt(i)); 
        }
        int contador=0; //verificar se todos os digitos são iguais
        for(int i=0;i<11;i++){
            if(digitos[0]==digitos[i]){
                contador++;
            }
        }
        if(contador==11){
            return false;
        }
            
        int primeiroDigitoVerificador = calcularVerificador(digitos);
        int segundoDigitoVerificador = calcularVerificadorDois(digitos);
        
        return primeiroDigitoVerificador==digitos[9] && segundoDigitoVerificador==digitos[10];
    }
    public int calcularVerificador(int[] digitos){
        int soma=0;
        for(int pesos =10, i=0; pesos>1 && i<9;pesos--, i++){
            soma += digitos[i]*pesos;
        }
        int resto= soma % 11;
        int verificadorUm = 11-resto;
        return verificadorUm >= 10 ? 0 : verificadorUm;
    }
    public int calcularVerificadorDois(int[] digitos){
        int soma=0;
        for(int pesos =11, i=0; pesos>1 && i<10;pesos--, i++){
            soma += digitos[i]*pesos;
        }
        int resto= soma % 11;
        int verificadorDois = 11-resto;
        return verificadorDois >= 10 ? 0 : verificadorDois;
    }
    
    //verificar nome
    public boolean validarNome(String nome){
        char[] letras = nome.toCharArray();
        char[] numChar = new char[42];
        if(letras.length < 4){
            return false;
        }          
        for(int k = 0; k < 32; k++){
            numChar[k] = (char)(k+33);
        }
        for(int l = 32; l < 38; l++){
            numChar[l] = (char) (l+59);
        }
        for(int m = 38; m < 42; m++){
            numChar[m] = (char) (m+85);
        }
        for(int i = 0; i < letras.length; i++){
           for(int j = 0; j < 32; j++){
               if(letras[i] == numChar[j]){
                   return false;
               }
           }
        }
        return true;      
    }
}
