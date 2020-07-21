package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.domain.Population;

@Repository
public interface PopulationDAO extends JpaRepository<Population,Integer>{

	
}
