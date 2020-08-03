package com.edu.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBootApplication;
import com.edu.domain.Population;
import com.edu.repository.PopulationDAO;
import com.edu.service.PopulationService;

@Component
public class PopulationServiceImpl implements PopulationService{
	
	@Autowired
	private PopulationDAO populationDAO;
	
	@Override
	public Population getPopuById(String id) {
		return populationDAO.findById(id).orElse(null);
	}
	
}


