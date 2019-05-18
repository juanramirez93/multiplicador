package com.ramper.repository;

import org.springframework.data.repository.CrudRepository;

import com.ramper.domain.Multiplication;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {

}
