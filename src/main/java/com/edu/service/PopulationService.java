package com.edu.service;

import java.util.List;


import com.edu.domain.Population;
import com.edu.common.PaginationResult;

public interface PopulationService {

	List<Population> getPopuById(String id);


	PaginationResult<List<Population>> getPopuPage(Integer pageIndex, Integer pageSize);
}
