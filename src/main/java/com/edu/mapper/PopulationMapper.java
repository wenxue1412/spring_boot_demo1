package com.edu.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.edu.domain.Population;

@Mapper
public interface PopulationMapper {
	
		
	@Select ("select * from `population` where id = #{id}")
	@ResultMap("PopulationResult")
	Population getPopuById(@Param("id")String id);
	
	
}
