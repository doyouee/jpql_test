package com.doyouee.jpql_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doyouee.jpql_test.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // select * from category_info where ci_name like %인%;  -> 테이블 기준
    // SELECT c.ciSeq FROM category_info c WHERE c.ciName LIKE %:key% // -> ENTITY 기준

    // @Query(value = "SELECT c.ciSeq FROM category_info c WHERE c.ciName LIKE %:key%")
    // List<Long> selectCategoryByKeyword(@Param("key") String keyword);

    // @Query(value = "SELECT c FROM category_info c WHERE c.ciName LIKE %:key%")
    // List<CategoryEntity> asd(@Param("key") String keyword);



    // ========================== << 다시 >> ========================= : Entity 코드에서 @Entity(name = "book_info") 이렇게 써주면 안돌아간대.. 왜죠
    @Query(value = "select c from CategoryEntity c where c.ciName like %:key%")
    public List<CategoryEntity> selectCategoryNameLikeKeyword(@Param("key") String keyword); //Param("") 안에 들어가는 것은 쿼리안에서 쓸 이름

}
