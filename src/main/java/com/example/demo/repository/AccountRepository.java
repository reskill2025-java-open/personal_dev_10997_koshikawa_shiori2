package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByName(String name);

	boolean existsByNameAndPassword(String name, String password);
}
