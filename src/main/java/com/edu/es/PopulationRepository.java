package com.edu.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.edu.domain.Population;

@Repository
public interface PopulationRepository extends ElasticsearchRepository<Population,Integer>{

}
