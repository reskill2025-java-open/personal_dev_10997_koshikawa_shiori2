package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Account;
import com.example.demo.model.AccountModel;
import com.example.demo.repository.AccountRepository;

@Controller
public class UserController {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	HttpSession session;

	@Autowired
	AccountModel account;

	@GetMapping("/users/new")
	public String registar() {
		return "signup";
	}

	//空欄か、passwordとpassword_confirmが一致しない時エラーを表示
	@PostMapping("/users/new")
	public String redirect_confirm(@RequestParam(name = "name") String name,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "password_confirm") String password_confirm, Model model) {

		if (name == null || name.length() == 0) {
			model.addAttribute("message", "名前を入力してください");

			return "signup";
		}

		if (password == null || password.length() == 0 || password_confirm == null || password_confirm.length() == 0) {
			model.addAttribute("message", "パスワードを正しく入力してください");

			return "signup";
		}

		if (!password.equals(password_confirm)) {
			model.addAttribute("message", "パスワードが一致しません");

			return "signup";
		}

		if (password.length() < 8) {
			model.addAttribute("message", "パスワードは8文字以上で入力してください");
			return "signup";
		}

		Account existingAccounts = accountRepository.findByName(name);
		if (existingAccounts != null) {
			model.addAttribute("message", "この名前は既に使用されています");

			return "signup";
		}

		model.addAttribute("name", name);

		model.addAttribute("password", password);
		model.addAttribute("password_confirm", password_confirm);

		Account account = new Account(name, password);
		accountRepository.save(account);

		return "signin";
	}

	@PostMapping("/users/add")
	public String add(@RequestParam(name = "name") String name,
			@RequestParam(name = "password") String password, Model model) {
		Account account = new Account(name, password);
		accountRepository.save(account);

		return "redirect:/login";
	}

	@GetMapping({ "/users", "/users/login", "/users/logout" })
	public String index() {
		session.invalidate();
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		if ((name == null || name.isEmpty()) || (password == null || password.isEmpty())) {
			model.addAttribute("message", "名前とパスワードを入力してください");
			return "login";
		}

		if (accountRepository.existsByNameAndPassword(name, password)) {
			Account nameCheck = accountRepository.findByName(name);
			account.setName(nameCheck.getName());
			account.setId(nameCheck.getId());
			//			account.setId(id);
			return "redirect:/calendar";
		}
		model.addAttribute("message", "名前とパスワードが一致しません");
		return "login";

	}

}
