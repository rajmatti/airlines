package com.coforge.training.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.airline.model.Card;

public interface CardRepo extends JpaRepository<Card, Long>{

}
