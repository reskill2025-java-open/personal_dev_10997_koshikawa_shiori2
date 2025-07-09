package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.KakeiboWithCategory;

public interface KakeiboWithCategoryRepository extends JpaRepository<KakeiboWithCategory, Integer> {
	//菊池さんのレポジトリを確認

	List<KakeiboWithCategory> findByDateBetween(LocalDate startDate, LocalDate endDate);

	List<KakeiboWithCategory> findByUserIdAndDate(Integer userid, LocalDate date);
}
