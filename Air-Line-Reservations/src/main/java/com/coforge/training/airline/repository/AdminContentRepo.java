package com.coforge.training.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.AdminContent;

@Repository
public interface AdminContentRepo extends JpaRepository<AdminContent, String>{

}
