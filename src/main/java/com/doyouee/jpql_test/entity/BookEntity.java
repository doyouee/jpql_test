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
// @Entity(name = "book_info")
@Entity
@Table(name = "book_info")
public class BookEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bi_seq")            private Long biSeq;
    @Column(name = "bi_title")          private String biTitle;
    @Column(name = "bi_price")          private Integer biPrice;
    @Column(name = "bi_discount")       private Double biDiscount;    
    @Column(name = "bi_point")          private Double biPoint;
    @Column(name = "bi_wi_seq")         private Long biWiSeq;
}
