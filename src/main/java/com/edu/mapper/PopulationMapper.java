package com.edu.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;

import com.edu.domain.Population;

@Mapper
public interface PopulationMapper {
	
		
	@Select ("select * from `population` where id = #{id}")
	@ResultMap("PopulationResult")
	Population getPopuById(@Param("id")String id);
	
	@Select ("select * from `population`")
	@ResultMap("PopulationResult")
	Page<Population> getPopuPage();
	
}
