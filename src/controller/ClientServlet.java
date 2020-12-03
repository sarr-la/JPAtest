package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.JPAtest.dao.ClientImp;
import sn.JPAtest.dao.IClient;
import sn.JPAtest.entities.Client;

@WebServlet(urlPatterns = "/Client", name ="Client")
public class ClientServlet extends HttpServlet {
	
	private IClient clientdao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		clientdao = new ClientImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	resp.getWriter().println("ok");
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}  
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = req.getParameter("nom").toString();
		String village = req.getParameter("village").toString();
		String adresse = req.getParameter("adresse").toString();
		String telephone = req.getParameter("telephone").toString();
		
		
		Client client = new Client();
		client.setNom(nom);
		client.setVillage(village);
		client.setAdresse(adresse);
		client.setTelephone(telephone);
		
		int ok = clientdao.add(client);
		resp.getWriter().println(ok);
	}
}
