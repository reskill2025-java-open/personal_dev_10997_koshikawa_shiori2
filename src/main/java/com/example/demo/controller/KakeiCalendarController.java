package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.KakeiboWithCategory;
import com.example.demo.model.AccountModel;
import com.example.demo.model.KakeiModel;
import com.example.demo.repository.KakeiRepository;
import com.example.demo.repository.KakeiboWithCategoryRepository;
import com.example.demo.service.KakeiService;

@Controller

public class KakeiCalendarController {

	@Autowired
	HttpSession session;

	@Autowired
	KakeiModel kakeiModel;

	@Autowired
	KakeiboWithCategoryRepository kakeiboWithCategoryRepository;

	@Autowired
	AccountModel accountModel;

	private final KakeiService kakeiService;

	@Autowired
	KakeiRepository kakeiRepository;

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
		List<KakeiboWithCategory> expenses = kakeiboWithCategoryRepository.findByDateBetween(firstDay,
				nextMonth.minusDays(1));

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
	public String showDailyList(@RequestParam("year") int year, @RequestParam("month") int month,
			@RequestParam("day") int day, Model model) {
		kakeiModel.setYear(year);
		kakeiModel.setDay(day);
		kakeiModel.setMonth(month);
		model.addAttribute("day", day);
		model.addAttribute("month", month);
		model.addAttribute("year", year);

		LocalDate date = LocalDate.of(year, month, day);
		Integer userId = accountModel.getId();
		System.out.println(userId);
		//この辺の記述をviewように直す、dailyList　htmlも直す
		model.addAttribute("kakeiboData",
				kakeiboWithCategoryRepository.findByUserIdAndDate(userId, date));
		return "dailyList";
	}

	//model作ってセッションスコープにデータ保存
}
