package sn.JPAtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.JPAtest.entities.Client;

public class ClientImp implements IClient{
	
	private EntityManager em;
	
	public ClientImp() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAtestPU");
	
	em = emf.createEntityManager();
}
@Override
public int add(Client client) {
	try {
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		return 1;
	}catch (Exception ex) {
		
		ex.printStackTrace();
		return 0;
	}
}
	
@Override 
public List<Client> list() {
	
	return em.createQuery("SELECT c FROM Client c").getResultList();

  }
}
