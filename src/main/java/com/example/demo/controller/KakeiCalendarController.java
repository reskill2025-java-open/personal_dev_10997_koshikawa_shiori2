package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.KakeiService;

@Controller

public class KakeiCalendarController {
	private final KakeiService kakeiService = new KakeiService();

	@GetMapping("/calendar")
	public String index(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month, Model model) {
		LocalDate today = LocalDate.now();

		//nullの場合は今日の年月を取得
		int currentYear = (year != null) ? year : today.getYear();
		int currentMonth = (month != null) ? year : today.getMonthValue();

		LocalDate firstDay = LocalDate.of(currentYear, currentMonth, 1);
		LocalDate prevMonth = firstDay.minusMonths(1);
		LocalDate nextMonth = firstDay.plusMonths(1);
		return "calendar";

	}

}
