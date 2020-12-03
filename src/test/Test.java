package test;

import sn.JPAtest.dao.ClientImp;
import sn.JPAtest.dao.IClient;
import sn.JPAtest.entities.Client;

public class Test {
	
	public static void main(String[] args) {

		IClient clientdao = new ClientImp();
		
		Client client = new Client();
		client.setNom("Moussa");
		client.setVillage("Fatick");
		client.setAdresse("Ngohe");
		client.setTelephone("775481425");
		
	int ok = clientdao.add(client);
	System.out.println(ok);
   }

}