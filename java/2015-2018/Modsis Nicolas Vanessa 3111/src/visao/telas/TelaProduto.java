package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoProduto;
import modelo.Produto;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaProduto {
	DaoProduto dP;
	Produto p;
    public TelaProduto(){
        try {
        	dP = new DaoProduto();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				p = new Produto();
				switch (opcao+1){
				case 1://Incluir
					p.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					p.setDescricao(JOptionPane.showInputDialog("Digite a descricao do produto"));
					p.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
					p.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do produto").replace(',', '.')));
					p.setTipo(JOptionPane.showInputDialog("Digite o tipo do produto"));
					dP.incluir(p);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					p.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					p.setDescricao(JOptionPane.showInputDialog("Digite a descricao do produto"));
					p.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
					p.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do produto").replace(',', '.')));
					p.setTipo(JOptionPane.showInputDialog("Digite o tipo do produto"));
					dP.alterar(p);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					p.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
					dP.excluir(p);
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
