package com.tunehub.project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunehub.project1.entity.Users;
import com.tunehub.project1.repositaries.UsersRepository;


@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "user added succesfuly";
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(email)==null)
		
			{
				return false;
			}
			else
			{
				return true;
			}
								
		}
	@Override
	public boolean validateUser(String email, String password) {
		Users user =repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass))
		
			{
				return true;
			}
			else
			{
				return false;
			}
						
		}
	@Override
	public String getRole(String email) {
		Users user =repo.findByEmail(email);
		return user.getRole();
	
	
}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	
	
	}
	

	


	
	


