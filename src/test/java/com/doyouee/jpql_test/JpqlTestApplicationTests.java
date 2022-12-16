package com.doyouee.jpql_test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doyouee.jpql_test.entity.BookEntity;
import com.doyouee.jpql_test.entity.CategoryEntity;
import com.doyouee.jpql_test.repository.BookRepository;
import com.doyouee.jpql_test.repository.CategoryRepository;
import com.doyouee.jpql_test.repository.WriterRepository;

@SpringBootTest
class JpqlTestApplicationTests {
	@Autowired CategoryRepository cateRepo;
	@Autowired WriterRepository writerRepo;
	@Autowired BookRepository bookRepo;

	@Test
	void loadCategories() {
		List<CategoryEntity> list = cateRepo.findAll();
		for(CategoryEntity cate : list) {
			System.out.println(cate);
		}
	}

	// @Test
	// void categoryKeyword() {
	// 	List<Long> list = cateRepo.selectCategoryByKeyword("인");
	// 	for(Long cate : list) {
	// 		System.out.println(cate);
	// 	}
	// }
	@Test
	void categoryKeyword() {
		List<CategoryEntity> list = cateRepo.selectCategoryNameLikeKeyword("인"); //여기서 "인" 이 keyword로 들어가고 그게 key로 돼서 selectCategoryNameLikeKeyword가 실행됨
		for(CategoryEntity cate : list) {
			System.out.println(cate);
		}
	}

	@Test
	void bookInfo() {
		List<BookEntity> list = bookRepo.searchBookTitle("벌", 0); // 0~9까지 목록의 책 중에서 "이"라는게 포함된 제목의 책을 찾아낸다 _2페이지에서 찾고싶으면 10으로 적는다. => 조건에 만족하는 애들만 페이지로 묶인다
		for(BookEntity b : list) {
			System.out.println(b);
		}
		Integer page = bookRepo.getBookPageCount("벌"); // 페이지 위치 찾기 => 조건에 만족하는 애들만 페이지로 묶인다
		System.out.println(page);
	}
}
