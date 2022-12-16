package com.doyouee.jpql_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity(name = "category_info") // 이 CategoryEntity라는 entity를 이 category_info라는 테이블 이름으로 매칭해놓음.
@Entity
@Table(name = "category_info")
public class CategoryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci_seq")    private Integer ciSeq; 
    @Column(name = "ci_name")   private String ciName; 
}
