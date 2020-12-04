
package felipe.continuada;


public abstract class Produto {
    
    protected String nome;
    protected String descricao;
    protected Double preco;
    protected Integer percentDesconto;
    protected Double precoComDesconto;
    protected Integer categoria;
    
    public void calcularDesconto() {
        this.precoComDesconto = preco - (preco * (percentDesconto * 0.01));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(Double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public Integer getPercentDesconto() {
        return percentDesconto;
    }

    public void setPercentDesconto(Integer percentDesconto) {
        this.percentDesconto = percentDesconto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    
}
