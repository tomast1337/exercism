package visao;
import dao.*;

/**
* @author Nicolas & Vanessa / T3111
*/

public class Carregar {
	DaoCliente daoCliente; 
	DaoCompra  daoCompra;
	DaoEstoque daoEstoque;
	DaoFornecedor daoFornecedor;
	DaoFuncionarios daoFuncionarios;
	DaoItensCompra daoItensCompra;
	DaoItensVenda daoItensVenda;
	DaoProduto daoProduto;
	DaoVenda daoVenda;
	
	Carregar(){
		try {
			daoCliente = new DaoCliente(); 
			daoCompra = new DaoCompra(); 
			daoEstoque = new DaoEstoque(); 
			daoFornecedor = new DaoFornecedor(); 
			daoFuncionarios = new DaoFuncionarios(); 
			daoItensCompra = new DaoItensCompra(); 
			daoItensVenda = new DaoItensVenda(); 
			daoProduto = new DaoProduto(); 
			daoVenda = new DaoVenda(); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
}