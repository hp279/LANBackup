package com.crossover.lanbackup.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.crossover.lanbackup.dao.ClientDao;
import com.crossover.lanbackup.dao.EmployeeDAO;
import com.crossover.lanbackup.dao.FolderDao;
import com.crossover.lanbackup.dao.impl.ClientDaoImpl;
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.service.ClientService;

public class App {

	public static void main(String[] args) {

	//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

	new App().test();

	
	}
	
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
		
		ClientDao clientDao = (ClientDao) ctx.getBean("ClientDao");
		
		Client client = new Client();
		Date now = new Date();
		client.setCreateDate(now);

		client.setIpAddress("195.195.34.34");
		client.setDstLogin("dst_login");
		client.setDstPassword("dst_password");
		client.setDstPassword("src_password");
		client.setEnabled(true);
		client.setLastUpdateDate(now);

		int clientId = clientDao.create(client);

		System.out.println("Client::" + client);

		List<Client> clients = clientDao.getAll();

		for (Client c : clients) {
			System.out.println("Client from list ::" + c);
		}
		// close resources
	//	context.close();
	}
}
