package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.ItensVenda;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoItensVenda {

	private SessionFactory fabrica;
	
	public DaoItensVenda()throws Exception{
		//Cria uma configura
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsvel em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(ItensVenda i) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(i);
		transacao.commit();
		sessao.close();
	}
	public void alterar(ItensVenda i) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(i);
		transacao.commit();
		sessao.close();
	}
	public void excluir(ItensVenda i) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(i);
		transacao.commit();
		sessao.close();
	}
	public ItensVenda consultar(ItensVenda i)throws Exception{
		ItensVenda iv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		iv = (ItensVenda)sessao.load(modelo.ItensVenda.class, i.getCodigo());
		transacao.commit();
		sessao.close();
		return iv;
	}
}
