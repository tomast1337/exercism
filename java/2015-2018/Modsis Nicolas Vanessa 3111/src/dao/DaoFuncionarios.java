package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Funcionario;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoFuncionarios {
	
	private SessionFactory fabrica;
	
	public DaoFuncionarios()throws Exception{
		//Cria uma configurao
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsvel em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Funcionario c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Funcionario c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Funcionario c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public Funcionario consultar(Funcionario c)throws Exception{
		Funcionario cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Funcionario)sessao.load(modelo.Funcionario.class, c.getCodigo());
		transacao.commit();
		sessao.close();
		return cv;
	}
}
