package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoFuncionarios;
import dao.DaoProduto;
import dao.DaoVenda;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaVenda {
	DaoVenda dV;
	DaoProduto dPro;
	DaoFuncionarios dFun;
	Venda v;
	Produto pro;
    public TelaVenda(){
        try {
        	dV = new DaoVenda();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				v = new Venda();
				switch (opcao+1){
				case 1://Incluir
					v.setData(JOptionPane.showInputDialog("Digite a data da venda"));
					v.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da venda")));
					if(JOptionPane.showConfirmDialog(null, "Pago?",null,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						v.setPago(true);
					else 
						v.setPago(false);
					dFun = new DaoFuncionarios();
					DaoProduto dPro = new DaoProduto();
					Funcionario fun = new Funcionario();
					pro = new Produto();
					fun.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do funcionario")));
					pro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					fun = dFun.consultar(fun);
					pro = dPro.consultar(pro);
					v.setFuncionario(fun);
					dV.incluir(v);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					v.setData(JOptionPane.showInputDialog("Digite a data da venda"));
					v.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da venda")));
					if(JOptionPane.showConfirmDialog(null, "Pago?",null,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						v.setPago(true);
					else 
						v.setPago(false);
					dFun = new DaoFuncionarios();
					dPro = new DaoProduto();
					fun = new Funcionario();
					pro = new Produto();
					fun.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do funcionario")));
					pro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					fun = dFun.consultar(fun);
					pro = dPro.consultar(pro);
					v.setFuncionario(fun);
					dV.alterar(v);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					v.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da venda")));
					dV.excluir(v);
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
