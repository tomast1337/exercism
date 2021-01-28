package visao;

import javax.swing.JOptionPane;

import visao.telas.TelaCliente;
import visao.telas.TelaCompra;
import visao.telas.TelaEstoque;
import visao.telas.TelaFornecedor;
import visao.telas.TelaFuncionario;
import visao.telas.TelaItensCompra;
import visao.telas.TelaItensVenda;
import visao.telas.TelaProduto;
import visao.telas.TelaVenda;

/**
* @author Nicolas & Vanessa / T3111
*/

public class Principal {
	static Carregar C;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C = new Carregar();
		Principal p = new Principal();
		p.menu();
	}
	public void menu(){
		Object[] OpcaosB = { "Sair","Cliente", "Compra","Estoque","Fornecedor","Funcionario","Itens Compra","Itens Vendas","Produtos","Venda"};
		int opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
		switch (opcao+1) {
		case 1://Sair
			JOptionPane.showMessageDialog(null, "Saindo...");
			System.exit(0);
			break;
		case 2://Cliente
			TelaCliente telaCliente = new TelaCliente();
			telaCliente = null;
			break;
		case 3://Compra
			TelaCompra telaCompra = new TelaCompra();
			telaCompra = null;
			break;
		case 4://Estoque
			TelaEstoque telaEstoque = new TelaEstoque();
			telaEstoque = null;
			break;
		case 5://Fornecedor
			TelaFornecedor telaFornecedor = new TelaFornecedor();
			telaFornecedor = null;
			break;
		case 6://Funcionario
			TelaFuncionario telaFuncionario = new TelaFuncionario();
			telaFuncionario = null;
			break;
		case 7://Itens Compra
			TelaItensCompra telaItensCompra = new TelaItensCompra();
			telaItensCompra = null;
			break;
		case 8://Itens Venda
			TelaItensVenda telaItensVenda = new TelaItensVenda();
			telaItensVenda = null;
			break;
		case 9://Produto
			TelaProduto telaProduto = new TelaProduto();
			telaProduto = null;
			break;
		case 10://Venda
			TelaVenda telaVenda = new TelaVenda();
			telaVenda = null;
			break;

		default:
			break;
		}
	}

}
