package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Estoque;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoEstoque {
	
	private SessionFactory fabrica;
	
	public DaoEstoque()throws Exception{
		//Cria uma configurao
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsvel em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Estoque c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Estoque c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Estoque c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public Estoque consultar(Estoque c)throws Exception{
		Estoque cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Estoque)sessao.load(modelo.Estoque.class, c.getProduto().getCodigo());
		transacao.commit();
		sessao.close();
		return cv;
	}
	
}
