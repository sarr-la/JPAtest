package sn.JPAtest.dao;

import java.util.List;

import sn.JPAtest.entities.*;
public interface IClient {
	
	public int add(Client client);
	public List<Client> list();

}
