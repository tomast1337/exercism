package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoCompra;
import dao.DaoFornecedor;
import modelo.Compra;
import modelo.Fornecedor;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaCompra {
	DaoCompra dC;
	DaoFornecedor dFon;
	Compra c;
	Fornecedor fon;
    public TelaCompra(){
        try {
        	dC = new DaoCompra();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				c = new Compra();
				switch (opcao+1){
				case 1://Incluir
					c.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da compra")));
					c.setData(JOptionPane.showInputDialog("Digite a data da compra"));
					dFon = new DaoFornecedor();
					fon = new Fornecedor();
					fon.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do fornecedor")));
 					fon = dFon.consultar(fon);
					c.setFornecedor(fon);
					dC.incluir(c);
					if(JOptionPane.showConfirmDialog(null, "Pago?",null,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						c.setPago(true);
					else 
						c.setPago(false);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					c.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da compra")));
					c.setData(JOptionPane.showInputDialog("Digite a data da compra"));
					dFon = new DaoFornecedor();
					fon = new Fornecedor();
					fon.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do fornecedor")));
 					fon = dFon.consultar(fon);
					c.setFornecedor(fon);
					dC.alterar(c);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					c.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da compra")));
					dC.excluir(c);
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					break;
				case 4://Consultar
				
					break;
				case 5://Voltar
					Principal p;
					p = new Principal();
					p.menu();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Nao foi possivel, ERRO: " + e.getMessage());
		}
    }

}
