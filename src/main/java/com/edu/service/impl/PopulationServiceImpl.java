package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.domain.Population;
import com.edu.mapper.PopulationMapper;
import com.edu.service.PopulationService;
@Component
public class PopulationServiceImpl implements PopulationService{
	
	@Autowired
	private PopulationMapper popuMapper;
	
	@Override
	public Population getPopuById(String id) {
		return popuMapper.getPopuById(id);
	}
	
}


