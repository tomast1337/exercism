package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoCliente;
import modelo.Cliente;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaCliente {
	DaoCliente dc;
	Cliente c;
	public TelaCliente() {
		try {
			dc = new DaoCliente();
			int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				c = new Cliente();
				switch (opcao+1){
				case 1://Incluir
					c.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Cliente")));
					c.setEndereco(JOptionPane.showInputDialog("Digite o endereco do Cliente"));
					c.setHistorico(JOptionPane.showInputDialog("Digite o Historico do Cliente"));
					c.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));
					dc.incluir(c);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					c.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Cliente")));
					c.setEndereco(JOptionPane.showInputDialog("Digite o endereco do Cliente"));
					c.setHistorico(JOptionPane.showInputDialog("Digite o Historico do Cliente"));
					c.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));
					dc.alterar(c);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					c.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Cliente")));
					dc.excluir(c);
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
