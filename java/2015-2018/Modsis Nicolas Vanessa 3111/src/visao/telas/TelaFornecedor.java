package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoFornecedor;
import modelo.Fornecedor;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaFornecedor {
	DaoFornecedor dF;
	Fornecedor f;
    public TelaFornecedor(){
        try {
        	dF = new DaoFornecedor();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				f = new Fornecedor();
				switch (opcao+1){
				case 1://Incluir
					f.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do fornecedor")));
					f.setNome(JOptionPane.showInputDialog("Digite o nome do fornecedor"));
					f.setQuantFornecida(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade fornecida do fornecedor")));
					f.setTelefone(JOptionPane.showInputDialog("Digite o telefone do fornecedor"));
					f.setTipo(JOptionPane.showInputDialog("Digite o tipo do produto do fornecedor"));
					dF.incluir(f);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
					
				case 2://Alterar
					f.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do fornecedor")));
					f.setNome(JOptionPane.showInputDialog("Digite o nome do fornecedor"));
					f.setQuantFornecida(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade fornecida do fornecedor")));
					f.setTelefone(JOptionPane.showInputDialog("Digite o telefone do fornecedor"));
					f.setTipo(JOptionPane.showInputDialog("Digite o tipo do produto do fornecedor"));
					dF.alterar(f);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					f.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do fornecedor")));
					dF.excluir(f);
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
