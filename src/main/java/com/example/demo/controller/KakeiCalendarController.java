package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Kakei;
import com.example.demo.service.KakeiService;

@Controller

public class KakeiCalendarController {
	private final KakeiService kakeiService;

	public KakeiCalendarController(KakeiService kakeiService) {
		this.kakeiService = kakeiService;
	}

	@GetMapping("/calendar")
	public String index(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month, Model model) {
		LocalDate today = LocalDate.now();

		//nullの場合は今日の年月を取得
		int currentYear = (year != null) ? year : today.getYear();
		int currentMonth = (month != null) ? month : today.getMonthValue();

		LocalDate firstDay = LocalDate.of(currentYear, currentMonth, 1);
		LocalDate prevMonth = firstDay.minusMonths(1);
		LocalDate nextMonth = firstDay.plusMonths(1);
		List<Kakei> expenses = kakeiService.findByMonth(currentYear, currentMonth);

		int firstDayOfWeek = firstDay.getDayOfWeek().getValue();
		firstDayOfWeek = (firstDayOfWeek == 7) ? 0 : firstDayOfWeek;
		int daysInMonth = firstDay.lengthOfMonth();

		model.addAttribute("year", currentYear);
		model.addAttribute("month", currentMonth);
		model.addAttribute("expenses", expenses);
		model.addAttribute("firstDayOfWeek", firstDayOfWeek);
		model.addAttribute("daysInMonth", daysInMonth);
		model.addAttribute("prevYear", prevMonth.getYear());
		model.addAttribute("prevMonth", prevMonth.getMonthValue());
		model.addAttribute("nextYear", nextMonth.getYear());
		model.addAttribute("nextMonth", nextMonth.getMonthValue());

		return "calendar";

	}

	@GetMapping("/dailyList")
	public String showDailyList() {
		return "dailyList";
	}

}
