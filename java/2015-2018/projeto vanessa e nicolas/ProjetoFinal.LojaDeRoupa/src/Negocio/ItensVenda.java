package Negocio;

/**
 *
 * @author Nicoals e Vanessa
 */
public class ItensVenda {
    private int idItensvenda;
    private int quantidade;
    private Venda venda;
    private Produto produto;

    public int getIdItensvenda() {
        return idItensvenda;
    }

    public void setIdItensvenda(int idItensvenda) {
        this.idItensvenda = idItensvenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
