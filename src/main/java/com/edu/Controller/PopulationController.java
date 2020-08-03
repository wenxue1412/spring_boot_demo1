package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.Population;
import com.edu.service.PopulationService;

@Controller
@RequestMapping("/popu")
public class PopulationController {
	
	@Autowired
	private PopulationService popuService;
	
	@RequestMapping("/info/{id}")
	@ResponseBody
	public Population getPopuById(@PathVariable String id) {
		return popuService.getPopuById(id);
	}

}
