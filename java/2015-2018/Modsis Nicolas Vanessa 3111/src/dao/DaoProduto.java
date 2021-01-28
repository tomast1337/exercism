package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Produto;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoProduto {

	private SessionFactory fabrica;
	
	public DaoProduto()throws Exception{
		//Cria uma configura
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsvel em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Produto c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Produto c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Produto c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public Produto consultar(Produto c)throws Exception{
		Produto cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Produto)sessao.load(modelo.Cliente.class, c.getCodigo());
		transacao.commit();
		sessao.close();
		return cv;
	}
}
