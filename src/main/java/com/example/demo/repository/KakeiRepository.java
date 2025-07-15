package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Kakei;

public interface KakeiRepository extends JpaRepository<Kakei, Integer> {
	@Query("SELECT k.price FROM Kakei k WHERE k.userId = :userId AND k.date BETWEEN :startDate AND :endDate")
	List<Integer> findPricesByUserIdAndDateBetween(
			@Param("userId") Integer userId,
			@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

	@Query("SELECT SUM(k.price)FROM Kakei k WHERE k.userId= :userId AND k.date BETWEEN :start AND :end")
	Integer getTotalByDateRange(@Param("userId") Integer userId, @Param("start") LocalDate start,
			@Param("end") LocalDate end);

	@Query("SELECT SUM(k.price)FROM Kakei k WHERE k.userId=:userId AND k.date=:date")
	Integer getTotalByDate(@Param("userId") Integer userId, @Param("date") LocalDate date);
}
