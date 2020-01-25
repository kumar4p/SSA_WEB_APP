package com.ats.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CitizenModel {
	private int cid;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String gender;
	
	private String stateCode;
}//class
