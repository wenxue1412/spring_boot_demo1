package com.edu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBootApplication;
import com.edu.domain.TestUser;
import com.edu.repository.TestUserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MySpringBootApplication.class)
public class TestUserTest{
	@Autowired
	private TestUserDAO testUserDAO;
	
	@Test
	public void testAdd() {
		TestUser u1 = new TestUser(1001,"Tom", new Date());
		TestUser u2 = new TestUser(1001,"Jerry", new Date());
		List<TestUser> list = new ArrayList<TestUser>();
		list.add(u1);
		list.add(u2);
		
		testUserDAO.saveAll(list);
		
	}
	
	@Test
	public void testSelect() {
		List<TestUser> list = testUserDAO.findAll();	
		for(TestUser u : list) {
			System.out.println(u);
		}
		TestUser u1 = testUserDAO.findByNameLike("%o%");
		System.out.println("find:" + u1);
	}
	
	
}