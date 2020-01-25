package com.ats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="StateDetails")
public class StatesEntity {
	@Id
	@Column(length = 6)
	private int stateId;
	@Column(length=25)
	private String stateName;
	@Column(length=5)
	private String stateCode;
}//class
