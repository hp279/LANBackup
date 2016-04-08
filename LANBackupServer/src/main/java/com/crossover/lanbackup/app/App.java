package com.crossover.lanbackup.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.repository.ClientDaoRepository;

public class App {

	public static void main(String[] args) {

	//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

	new App().test();

	
	}
	
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
		
		ClientDaoRepository clientDao = (ClientDaoRepository) ctx.getBean("clientDaoRepository");
		
		clientDao.deleteAll();
		
		Client client = new Client();
		Date now = new Date();
		client.setCreateDate(now);

		client.setIpAddress("195.195.34.34");
		client.setDstLogin("dst_login");
		client.setDstPassword("dst_password");
		client.setSrcLogin("src_login");
		client.setSrcPassword("src_password");
		client.setEnabled(true);
		client.setLastUpdateDate(now);

		client = clientDao.save(client);

		System.out.println("Client::" + client);

		List<Client> clients = (List<Client>) clientDao.findAll();

		for (Client c : clients) {
			System.out.println("Client from list ::" + c);
		}
		
		clientDao.delete(client);
		// close resources
	//	context.close();
	}
}
