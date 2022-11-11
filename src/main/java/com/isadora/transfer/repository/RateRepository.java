package com.isadora.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isadora.transfer.model.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {

}
