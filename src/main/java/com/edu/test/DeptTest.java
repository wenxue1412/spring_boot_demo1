package com.edu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBootApplication;
import com.edu.domain.DeptInfo;
import com.edu.mapper.DeptMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MySpringBootApplication.class)
public class DeptTest {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Test
	public void deptListTest() {
		List<DeptInfo> list = deptMapper.getDeptList();
		for(DeptInfo dept : list) {
			System.out.println(dept);
		}
	}
}
