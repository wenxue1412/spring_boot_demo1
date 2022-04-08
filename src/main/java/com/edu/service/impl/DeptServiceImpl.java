package com.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.domain.DeptInfo;
import com.edu.es.DeptRepository;
import com.edu.mapper.DeptMapper;
import com.edu.service.DeptService;
@Component
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public List<DeptInfo> findDeptById(Integer id) {
		// TODO Auto-generated method stub
		List<DeptInfo> list = new ArrayList<DeptInfo>();
		list.add(deptMapper.findDeptById(id));
		return list;
	}

	@Override
	public List<DeptInfo> findDeptList() {
		return deptMapper.findDeptList();
	}

	@Override
	public List<DeptInfo> findDeptByLoc(String loc) {
		List<DeptInfo> list = deptRepository.findByLoc(loc);
		return list;
	}

	@Override
	public List<DeptInfo> findDeptByDname(String dname) {
		// TODO Auto-generated method stub
		return deptRepository.findByDname(dname);
	}

	@Override
	public List<DeptInfo> deleteDeptById(Integer id) {
		deptMapper.deleteDept(id);
		return deptMapper.findDeptList();
	}

	@Override
	public void updateDept(DeptInfo dept) {
		deptMapper.updateDept(dept);
	}

	@Override
	public void addDept(DeptInfo dept) {
		List<DeptInfo> deptList = deptMapper.findDeptList();
		Integer deptno = 0;
		for (DeptInfo deptDB : deptList) {
			if (deptDB.getDeptno() > deptno) {
				deptno = deptDB.getDeptno();
			}
		}
		dept.setDeptno(deptno + 1);
		deptMapper.addDept(dept);

	}

	@Override
	public List<DeptInfo> deleteDept(List<Integer> ids) {
		for(int id : ids) {
			deptMapper.deleteDept(id);
		}
		return deptMapper.findDeptList();
	}
}
