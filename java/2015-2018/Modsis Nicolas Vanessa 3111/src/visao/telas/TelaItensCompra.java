package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoCompra;
import dao.DaoItensCompra;
import modelo.Compra;
import modelo.ItensCompra;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaItensCompra {
	DaoItensCompra dIC;
	DaoCompra dCom;
	ItensCompra iC;
	Compra com;
	public TelaItensCompra(){
        try {
        	dIC = new DaoItensCompra();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				iC = new ItensCompra();
				switch (opcao+1){
				case 1://Incluir
					com = new Compra();
					dCom = new DaoCompra();
					com.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da compra")));
					com = dCom.consultar(com);
					iC.setCompra(com);
					iC.setCodigoP(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto da compra")));
					iC.setQuant(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade da compra")));
					dIC.incluir(iC);
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					com = new Compra();
					dCom = new DaoCompra();
					com.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da compra")));
					com = dCom.consultar(com);
					iC.setCompra(com);
					iC.setCodigoP(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto da compra")));
					iC.setQuant(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade da compra")));
					dIC.alterar(iC);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
					iC.setCodigoP(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto da compra")));
					dIC.alterar(iC);
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
