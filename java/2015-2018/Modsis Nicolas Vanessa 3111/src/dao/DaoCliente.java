package dao;

/**
* @author Nicolas & Vanessa / T3111
*/

import modelo.Cliente;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DaoCliente {
	
	private SessionFactory fabrica;
	
	public DaoCliente()throws Exception{
		//Cria uma configuração
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//Le o arquivo hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		//Cria o objeto fabrica responsável em criar os objetos Sessions
		fabrica = configuration.buildSessionFactory();	
	}
	
	public void incluir(Cliente c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.close();
	}
	public void alterar(Cliente c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.close();
	}
	public void excluir(Cliente c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao= sessao.beginTransaction();
		sessao.delete(c);
		transacao.commit();
		sessao.close();
	}
	public Cliente consultar(Cliente c)throws Exception{
		Cliente cv;
		Session sessao =fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		cv = (Cliente)sessao.load(modelo.Cliente.class, c.getCodigo());
		transacao.commit();
		sessao.close();
		return cv;
	}
	
}
