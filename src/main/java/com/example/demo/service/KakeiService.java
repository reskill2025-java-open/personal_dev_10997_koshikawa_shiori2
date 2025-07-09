package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KakeiRepository;

@Service

public class KakeiService {
	@Autowired
	KakeiRepository kakeiRepository;

	//	public List<Kakei> findByMonth(int year, int month) {
	//		LocalDate start = LocalDate.of(year, month, 1);
	//		LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
	//		Date startDate = java.sql.Date.valueOf(start);
	//		Date endDate = java.sql.Date.valueOf(end);
	//		return kakeiRepository.findByDateBetween(startDate, endDate);
	//	}
}
