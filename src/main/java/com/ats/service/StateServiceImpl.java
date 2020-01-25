package com.ats.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.entity.StatesEntity;
import com.ats.repository.StatesRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StatesRepository stateRepository;
	@Override
	public Map<String, String> getStatesMap() {
		Map<String,String> statesMap = new HashMap<String, String>();
		List<StatesEntity> statesList = stateRepository.findAll();
		statesList.forEach(entity->{
			statesMap.put(entity.getStateCode(),entity.getStateName());
		});
		return statesMap;
	}//getStatesMap()

}//class
