package com.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.edu.domain.DeptInfo;


@Mapper
public interface DeptMapper {
	@Select("select * from dept")
	@ResultMap("deptInfoResult")
	List<DeptInfo>findDeptList();
	@Select ("select * from dept where deptno = #{deptno}")
	@ResultMap("deptInfoResult")
	DeptInfo findDeptById(@Param("deptno")Integer deptno);
	@Select("select count(*) as cnt from dept")
	Integer findDeptCount();

	@Select("select * from dept limit #{cursor},#{offset}")
	@ResultMap("deptInfoResult")
	List<DeptInfo>getDeptPage(@Param("cursor")Integer cursor , @Param("offset")Integer offset);

	Integer addDept(DeptInfo dept);

	Integer updateDept(DeptInfo dept);

	@Delete("delete from dept where deptno = #{deptno}")
	Integer deleteDept(@Param("deptno") Integer deptno);


}
