package dao;
/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Compra;
import modelo.ItensCompra;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
public class DaoCompra {

	private SessionFactory fabrica;
	
	public DaoCompra()throws Exception{
		//Cria uma configuração
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsável em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Compra iC) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(iC);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Compra c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Compra c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public Compra consultar(Compra com)throws Exception{
		Compra cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Compra)sessao.load(modelo.Compra.class, com.getNumero());
		transacao.commit();
		sessao.close();
		return cv;
	}
}
