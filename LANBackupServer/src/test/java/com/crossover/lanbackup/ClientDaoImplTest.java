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

import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.repository.ClientDaoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class ClientDaoImplTest {

	@Autowired
	private ClientDaoRepository clientDao;
	
	@Test
    @Transactional
    public void testAddClient() {
        DepartmentEntity department = new DepartmentEntity("Information Technology");
        departmentDAO.addDepartment(department);
         
        List<DepartmentEntity> departments = departmentDAO.getAllDepartments();
        Assert.assertEquals(department.getName(), departments.get(0).getName());
    }

	@Transactional
	@Test
	public void testGetClientById() {
		Client client = clientDao.findOne(1);
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
		client.setSrcLogin("src_login");
		client.setSrcPassword("src_password");
		client.setEnabled(true);
		client.setLastUpdateDate(now);

		client = clientDao.save(client);

		assertEquals(2, client.getId());
	}
}
