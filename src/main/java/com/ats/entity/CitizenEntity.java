package com.ats.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="CitizenDetails")
public class CitizenEntity {
	@ApiModelProperty(notes = "the database generated citizen id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ssaId")
	@SequenceGenerator(sequenceName = "ssa_seq" ,name = "ssaId",initialValue = 1000001,allocationSize = 1)
	private int cid;
	@Column(length = 15,name = "FIRST_NAME")
	private String fname;
	@Column(length = 15,name = "LAST_NAME")
	private String lname;
	@Column(name="DATE_OF_BIRTH")
	private Date dob;
	@Column(length=10)
	private String gender;
	@Column(length=8)
	private String stateCode;
}//class
