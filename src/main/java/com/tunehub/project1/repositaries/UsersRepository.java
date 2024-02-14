package com.tunehub.project1.repositaries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.project1.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	 public Users findByEmail(String email);
	 

	

}
