package com.edu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.edu.MySpringBootApplication;
import com.edu.domain.DeptInfo;
import com.edu.es.DeptRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class ElasticTest {
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Test
	public void test() {
		List<DeptInfo> list = deptRepository.findByLoc("东京");
		for(DeptInfo dept : list) {
			System.out.println(dept);
		}
	}
}
