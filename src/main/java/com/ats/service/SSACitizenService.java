package com.ats.service;

import com.ats.model.CitizenModel;

public interface SSACitizenService {
	public boolean registerCitizen(CitizenModel citizenModel);
	public String getCitizenStateCodeByCitizenId(int id);
}
