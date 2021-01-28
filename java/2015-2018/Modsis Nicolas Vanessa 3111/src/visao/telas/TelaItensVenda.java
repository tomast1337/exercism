package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoItensVenda;
import dao.DaoVenda;
import modelo.ItensVenda;
import modelo.Venda;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaItensVenda{ 
	DaoItensVenda dIV;
	DaoVenda dVen;
	ItensVenda iv;
	Venda ven;
    public TelaItensVenda(){
        try {
        	dIV = new DaoItensVenda();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				iv = new ItensVenda();
				switch (opcao+1){
				case 1://Incluir
					iv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo")));
					iv.setQunatidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade")));
					dVen = new DaoVenda();
					ven = new Venda();
					ven = dVen.consultar(ven);
					iv.setVenda(ven);
					dIV.incluir(iv);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					iv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo")));
					iv.setQunatidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade")));
					dVen = new DaoVenda();
					ven = new Venda();
					ven = dVen.consultar(ven);
					iv.setVenda(ven);
					dIV.alterar(iv);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					iv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo")));
					dIV.excluir(iv);
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
