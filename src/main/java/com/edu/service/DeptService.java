package com.edu.service;

import java.util.List;

import com.edu.domain.DeptInfo;


public interface DeptService {

	List<DeptInfo> findDeptById(Integer deptno);
    List<DeptInfo> findDeptList();
    List<DeptInfo> findDeptByLoc(String loc);
	List<DeptInfo> findDeptByDname(String dname);
	List<DeptInfo> deleteDeptById(Integer id);
	void updateDept(DeptInfo dept);
	void addDept(DeptInfo dept);
	List<DeptInfo> deleteDept(List<Integer> ids);
}
