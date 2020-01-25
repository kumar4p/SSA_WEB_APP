package com.ats.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.entity.CitizenEntity;
import com.ats.model.CitizenModel;
import com.ats.repository.SSACitizenRepository;

@Service
public class SSACitizenServiceImpl implements SSACitizenService{
	@Autowired
	private SSACitizenRepository ssaCtzenRpo;
	@Override
	public boolean registerCitizen(CitizenModel citizenModel) {
		boolean flag=false;
		CitizenEntity citizenEntity = new CitizenEntity();
		BeanUtils.copyProperties(citizenModel, citizenEntity);
		 citizenEntity = ssaCtzenRpo.save(citizenEntity);
		 if(citizenEntity.getCid()!=0)
			flag = true;
		 return flag;
	}//registerCitizen(-)
	
	@Override
	public String getCitizenStateCodeByCitizenId(int id) {
		String cid =null;
		Optional<CitizenEntity> optional = ssaCtzenRpo.findById(id);
		if(optional.isPresent())
			cid = optional.get().getStateCode();
		return cid;
	}//getCitizenStateIdByCitizenId(-)
}//class
