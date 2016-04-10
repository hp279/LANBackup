package com.crossover.lanbackup.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.repository.ClientDaoRepository;
import com.crossover.lanbackup.service.ClientService;

public class App {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext context = new
        // ClassPathXmlApplicationContext("application-context.xml");

        new App().test();

    }

    public void test() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");
        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));

        ClientDaoRepository clientDao = (ClientDaoRepository) ctx
                .getBean("clientDaoRepository");
        
        ClientService clientService = (ClientService) ctx
                .getBean("clientService");

        clientDao.deleteAll();

        

        Client client = new Client();
        Date now = new Date();
        client.setCreateDate(now);

        client.setIpAddress("127.0.0.1");
        client.setDstLogin("local_login");
        client.setDstPassword("local_password");
        client.setSrcLogin("local_login");
        client.setSrcPassword("local_password");
        client.setEnabled(true);
        client.setLastUpdateDate(now);

        client = clientService.save(client);
        System.out.println("ClientDTO::" + client);
        
        for (int i = 0; i < 10; i++) {
            client = new Client();
            now = new Date();
            client.setCreateDate(now);

            client.setIpAddress("195.195.34.00" + i);
            client.setDstLogin("dst_login" + i);
            client.setDstPassword("dst_password" + i);
            client.setSrcLogin("src_login" + i);
            client.setSrcPassword("src_password" + i);
            client.setEnabled(true);
            client.setLastUpdateDate(now);

            client = clientService.save(client);
            System.out.println("ClientDTO::" + client);
        }

        List<Client> clients = (List<Client>) clientDao.findAll();

        for (Client c : clients) {
            System.out.println("ClientDTO from list ::" + c);
        }

     //   clientDao.delete(client);
        // close resources
        // context.close();
    }
}
