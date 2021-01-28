package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Venda;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoVenda {
	
	private SessionFactory fabrica;
	
	public DaoVenda()throws Exception{
		//Cria uma configuração
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsável em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Venda v) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(v);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Venda v) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(v);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Venda v) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(v);
		transacao.commit();
		sessao.close();
	}
	public Venda consultar(Venda v)throws Exception{
		Venda cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Venda)sessao.load(modelo.Cliente.class, v.getNumero());
		transacao.commit();
		sessao.close();
		return cv;
	}
	
}
