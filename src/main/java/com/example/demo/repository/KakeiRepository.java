package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Kakei;

public interface KakeiRepository extends JpaRepository<Kakei, Integer> {
	List<Kakei> findByDateBetween(Date startDate, Date endDate);

}
