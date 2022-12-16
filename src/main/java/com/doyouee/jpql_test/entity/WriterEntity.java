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
// @Entity(name = "writer_info")
@Entity
@Table(name = "writer_info")
public class WriterEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wi_seq")            private Long wiSeq;
    @Column(name = "wi_name")           private String wiName;
    @Column(name = "wi_job")            private String wiJob;
    @Column(name = "wi_introduce")      private String wiIntroduce;    
    @Column(name = "wi_pic_file")       private String wiPicFile;    
}
