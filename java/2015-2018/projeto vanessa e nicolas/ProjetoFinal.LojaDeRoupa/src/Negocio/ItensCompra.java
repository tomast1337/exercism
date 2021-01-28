package Negocio;

/**
 *
 * @author Nicoals e Vanessa
 */
public class ItensCompra {
    private int idItenscompra;
    private int quantidade;
    private Compra compra;
    private Produto produto;

    public int getIdItenscompra() {
        return idItenscompra;
    }

    public void setIdItenscompra(int idItenscompra) {
        this.idItenscompra = idItenscompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
