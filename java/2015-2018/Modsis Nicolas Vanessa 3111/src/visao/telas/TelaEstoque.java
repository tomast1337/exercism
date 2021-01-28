package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoEstoque;
import dao.DaoProduto;
import modelo.Estoque;
import modelo.Produto;
import visao.Principal;

public class TelaEstoque {
	DaoEstoque dE;
	DaoProduto dPro;
	Estoque e;
	Produto pro;
    public TelaEstoque(){
        try {
        	dE = new DaoEstoque();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				e = new Estoque();
				switch (opcao+1){
				case 1://Incluir
					pro = new Produto();
					dPro = new DaoProduto();
					pro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					pro = dPro.consultar(pro);
					e.setProduto(pro);
					e.setQuantMax(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade maxima do Estoque")));
					e.setQuantMin(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade minima do Estoque")));
					dE.incluir(e);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					pro = new Produto();
					dPro = new DaoProduto();
					pro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					pro = dPro.consultar(pro);
					e.setProduto(pro);
					e.setQuantMax(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade maxima do Estoque")));
					e.setQuantMin(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade minima do Estoque")));
					dE.alterar(e);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					pro = new Produto();
					dPro = new DaoProduto();
					pro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					pro = dPro.consultar(pro);
					e.setProduto(pro);
					dE.excluir(e);
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
