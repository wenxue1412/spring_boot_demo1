package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.domain.DeptInfo;
import com.edu.mapper.DeptMapper;
import com.edu.service.DeptService;
@Component
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public DeptInfo getDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptMapper.getDeptById(id);
	}
}
