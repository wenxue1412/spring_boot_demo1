package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.Population;
import com.edu.service.PopulationService;

import com.edu.common.PaginationResult;


@Controller
@RequestMapping("/popu")
public class PopulationController {

	@Autowired
	private PopulationService popuService;

	@RequestMapping("/info/{id}")
	@ResponseBody
	public List<Population> getPopuById(@PathVariable String id) {
		return popuService.getPopuById(id);
	}

	@RequestMapping(value = "/page",method =RequestMethod.GET)
	@ResponseBody
	public PaginationResult<List<Population>> getPage(Integer pageIndex, Integer pageSize){
		return popuService.getPopuPage(pageIndex,pageSize);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getMain(ModelMap modelMap, Integer pageIndex, Integer pageSize) {
		modelMap.put("pageIndex", pageIndex);
		modelMap.put("pageSize", pageSize);
		return "popu";
	}

}
