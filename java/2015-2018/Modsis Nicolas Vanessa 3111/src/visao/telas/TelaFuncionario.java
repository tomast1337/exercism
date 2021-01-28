package visao.telas;

import javax.swing.JOptionPane;

import dao.DaoFuncionarios;
import modelo.Funcionario;
import visao.Principal;

/**
 * @author Nicolas & Vanessa / T3111
 */

public class TelaFuncionario {
	DaoFuncionarios dF;
	Funcionario f;
    public TelaFuncionario(){
        try {
        	dF = new DaoFuncionarios();
        	int opcao = 0;
			while(opcao != 4){
				Object[] OpcaosB = { "Incluir","Alterar","Excluir","Consultar","Voltar"};
				opcao =JOptionPane.showOptionDialog(null, null, "Registo loja",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, OpcaosB, null);
				f = new Funcionario();
				switch (opcao+1){
				case 1://Incluir
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
					break;
				case 2://Alterar
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					break;
				case 3 ://Excluir
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
