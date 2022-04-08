package com.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.domain.Population;
import com.edu.repository.PopulationDAO;
import com.edu.service.PopulationService;

import com.edu.common.Pagination;
import com.edu.common.PaginationResult;


@Component
public class PopulationServiceImpl implements PopulationService{

	@Autowired
	private PopulationDAO populationDAO;

	@Override
	public List<Population> getPopuById(String id) {
		if("0".equals(id)) {
			List<Population> all = populationDAO.findAll();
			List<Population> list = new ArrayList<Population>();
			for (int i = 0; i < 10; i++) {
				list.add(all.get(i));
			}
			return list;
		} else {
			List<Population> list = new ArrayList<Population>();
			Population population = populationDAO.findById(id).orElse(null);
			list.add(population);
			return list;
		}
	}

	@Override
	public PaginationResult<List<Population>> getPopuPage(Integer pageIndex, Integer pageSize) {
		Pagination pagination = new Pagination(pageIndex,pageSize);
		Integer totalCount = (int) populationDAO.count();
		pagination.setTotalCount(totalCount);
		List<Population> all = populationDAO.findAll();
		List<Population> list = new ArrayList<Population>();
		for (int i = pagination.getCursor(); i < pagination.getCursor() + pagination.getOffset(); i++) {
			list.add(all.get(i));
		}
		pagination.setCurrentPageCount(list.size());
		PaginationResult<List<Population>> result = new PaginationResult<List<Population>>(pagination,list);
		return result;
	}

}


