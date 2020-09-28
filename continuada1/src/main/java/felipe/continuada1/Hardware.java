package felipe.continuada1;

public class Hardware {
    
    String nome;
    String mascara;
    
    Integer atual;
    
    Integer minimo;
    Integer maximo = 0;
    Integer soma = 0;
    
    Integer maximoPossivel;
    
    void atualizarLeitura(Integer novoValor) {
        atual = novoValor;
        soma += novoValor;
        
        if (novoValor < minimo) {
            minimo = novoValor;
        }
        
        if (novoValor > maximo) {
            maximo = novoValor;
        }
        
    }
}
