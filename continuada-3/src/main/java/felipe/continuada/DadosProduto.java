
package felipe.continuada;

public class DadosProduto {
    
    public static String definirCategoria(Integer numeroCategoria) {
        Produto produtoAtual;
        
        switch (numeroCategoria) {
            case 0:
                produtoAtual = new Eletronicos();
                break;
            case 1:
                produtoAtual = new Livros();
                break;
            case 2:
                produtoAtual = new Comida();
                break;
            default:
                produtoAtual = new Eletronicos();
                break;
        }
        
        String NomeCategoria = produtoAtual.getNome();
        
        return NomeCategoria;
    }
    
    public static Double definirValorDesconto(Integer numeroCategoria, Double precoProduto) {
        Produto produtoAtual;
        
        switch (numeroCategoria) {
            case 0:
                produtoAtual = new Eletronicos();
                break;
            case 1:
                produtoAtual = new Livros();
                break;
            case 2:
                produtoAtual = new Comida();
                break;
            default:
                produtoAtual = new Eletronicos();
                break;
        }
        
        produtoAtual.setPreco(precoProduto);
        produtoAtual.calcularDesconto();
        Double valorDesconto = produtoAtual.getPrecoComDesconto();
        
        return valorDesconto;
    }
        
    public static Integer definirDesconto(Integer numeroCategoria) {
        Produto produtoAtual;
        
        switch (numeroCategoria) {
            case 0:
                produtoAtual = new Eletronicos();
                break;
            case 1:
                produtoAtual = new Livros();
                break;
            case 2:
                produtoAtual = new Comida();
                break;
            default:
                produtoAtual = new Eletronicos();
                break;
        }
        
        Integer valorDesconto = produtoAtual.getPercentDesconto();
        
        return valorDesconto;
    }
}
