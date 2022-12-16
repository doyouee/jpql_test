package com.doyouee.jpql_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doyouee.jpql_test.entity.WriterEntity;

public interface WriterRepository extends JpaRepository<WriterEntity, Long> {
    
}
