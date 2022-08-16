package com.coforge.training.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);

	public boolean existsByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

	public boolean existsByEmailAndMobileno(String email, String phoneno);

}
