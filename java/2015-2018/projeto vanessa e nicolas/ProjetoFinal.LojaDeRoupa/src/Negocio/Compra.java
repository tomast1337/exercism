package Negocio;

/**
 *
 * @author Nicoals e Vanessa
 */
public class Compra {
    private int idCompra;
    private String Data;
    private boolean Pago;
    private Fornecedor fornecedor;
    private Caixa caixa;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public boolean isPago() {
        return Pago;
    }

    public void setPago(boolean Pago) {
        this.Pago = Pago;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
