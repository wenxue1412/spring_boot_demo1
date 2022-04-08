package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.DeptInfo;
import com.edu.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@RequestMapping("/info/{id}")
	@ResponseBody
	public List<DeptInfo> getDeptById(@PathVariable Integer id) {
		return deptService.findDeptById(id);
	}

	@RequestMapping("/all")
	@ResponseBody
	public List<DeptInfo> getDeptList(){
		return deptService.findDeptList();
	}
	@RequestMapping("/loc/{loc}")
	@ResponseBody
	public List<DeptInfo>getDeptByLoc(@PathVariable String loc){
		return deptService.findDeptByLoc(loc);

	}
	@RequestMapping("/dname/{dname}")
	@ResponseBody
	public List<DeptInfo>getDeptByDname(@PathVariable String dname){
		return deptService.findDeptByDname(dname);

	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public List<DeptInfo> deleteDeptById(@PathVariable Integer id) {
		return deptService.deleteDeptById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public DeptInfo updateDept(@RequestBody DeptInfo dept) {
		deptService.updateDept(dept);
		return dept;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public DeptInfo addDept(@RequestBody DeptInfo dept) {
		deptService.addDept(dept);
		return dept;
	}
	@RequestMapping(value = "/deleteMulti", method = RequestMethod.POST)
	@ResponseBody
	public List<DeptInfo> deleteMultiDept(@RequestBody List<Integer> ids) {
		return deptService.deleteDept(ids);
	}
}
