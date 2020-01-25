package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.entity.CitizenEntity;

public interface SSACitizenRepository  extends JpaRepository<CitizenEntity, Integer> {

}
