package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.ItensCompra;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoItensCompra {
	
	private SessionFactory fabrica;
	
	public DaoItensCompra()throws Exception{
		//Cria uma configurao
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsvel em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(ItensCompra c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.close();
	}
	public void alterar(ItensCompra c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(ItensCompra c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public ItensCompra consultar(ItensCompra c)throws Exception{
		ItensCompra cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (ItensCompra)sessao.load(modelo.ItensCompra.class, c.getCompra().getNumero());
		transacao.commit();
		sessao.close();
		return cv;
	}
}
