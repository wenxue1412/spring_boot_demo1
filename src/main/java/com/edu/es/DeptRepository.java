package com.edu.es;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.edu.domain.DeptInfo;

@Repository
public interface DeptRepository extends ElasticsearchRepository<DeptInfo, Integer>{

	List<DeptInfo> findByDname(String dname);
	
	List<DeptInfo> findByLoc(String loc);
}
