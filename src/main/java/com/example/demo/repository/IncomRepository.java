package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Incom;

public interface IncomRepository extends JpaRepository<Incom, Integer> {

	List<Incom> findByUserIdAndDateBetween(Integer userId, Date startDate, Date endDate);

	List<Incom> findByUserIdAndDate(Integer userid, LocalDate date);

	@Query("SELECT i.price FROM Incom i WHERE i.userId = :userId AND i.date BETWEEN :startDate AND :endDate")
	List<Integer> findPricesByUserIdAndDateBetween(
			@Param("userId") Integer userId,
			@Param("startDate") java.sql.Date startDate,
			@Param("endDate") java.sql.Date endDate);
}
