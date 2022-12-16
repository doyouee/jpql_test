package com.doyouee.jpql_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doyouee.jpql_test.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    //@Query(value = "select * from book_info where bi_title like %%")
    //@Query(value = "select b from BookEntity b where b.biTitle like %:keyword% limit 10 offset :offset", nativeQuery = true) // JPQL형식으로 바꿔보기 _  nativeQuery = true : mysql구문을 쓰겠다 -> 이러면 mysql밖에 못씀(jpa 쓰는 이유가 없어짐)
    @Query(value = "select * from book_info where bi_title like %:keyword% limit 10 offset :offset", nativeQuery = true)
    List<BookEntity> searchBookTitle(@Param("keyword") String keyword, @Param("offset") Integer offset);
    @Query(value = "select ceil(count(b)/10) from BookEntity b where b.biTitle like %:keyword%") // 총 페이지 수 가져오기(카운트하기)
    Integer getBookPageCount(@Param("keyword") String keyword);
}
