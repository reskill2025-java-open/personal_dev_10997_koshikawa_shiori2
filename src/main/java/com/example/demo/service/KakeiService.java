package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kakei;
import com.example.demo.repository.KakeiRepository;

@Service

public class KakeiService {
	@Autowired
	KakeiRepository kakeiRepository;

	public Map<Integer, List<Kakei>> groupByDayOfMonth(int year, int month) {
		List<Kakei> expenses = findByMonth(year, month);
		return expenses.stream()
				.collect(Collectors.groupingBy(exp -> {
					LocalDate localDate = new java.sql.Date(exp.getDate().getTime()).toLocalDate();
					return localDate.getDayOfMonth();

				}));

	}

	public List<Kakei> findByMonth(int year, int month) {
		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
		Date startDate = java.sql.Date.valueOf(start);
		Date endDate = java.sql.Date.valueOf(end);
		return kakeiRepository.findByDateBetween(startDate, endDate);
	}
}
