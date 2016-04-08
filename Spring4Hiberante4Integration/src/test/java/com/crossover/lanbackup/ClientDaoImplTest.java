package com.crossover.lanbackup;

import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.crossover.lanbackup.dao.ClientDao;
import com.crossover.lanbackup.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class ClientDaoImplTest {

	@Autowired
	private ClientDao clientDao;

	@Transactional
	@Test
	public void testGetClientById() {
		Client client = clientDao.get(1);
		assertNotNull(client);
	}

	@Transactional
	@Test
	public void testCreateClient() {
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

		assertEquals(2, clientId);
	}
}
