package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;

@Transactional
@Service
public class UserService {
	
	@Autowired
    private UserRepository repository ;
	
	public String login(Users user1) {
		String ch;
        Users user = repository.findByEmail(user1.getEmail());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(user1.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        if (user.getRole().equals(Role.admin) ) {
        	ch = "admin";
        }
        else {
        	ch = "login succes";
        }
        return ch ;
    }
	
	public Users saveUser (Users user) {
		return repository.save(user);
	}
	
	public void deleteUserById (Long id) {
		repository.deleteById(id);
	}
	
	public void deleteUser (Users user) {
		repository.delete(user); ;
	}
	
	public void changepwdUser (Users user) {
		repository.changeUserPassword(user.getPassword(), user.getId());
	}
	
	public void changemailUser (Users user) {
		repository.changeUserEmail(user.getEmail(), user.getId());
	}
	
	public void changeroleUser (Users user) {
		repository.changeUserRole(user.getRole(), user.getId());
	}
	
	public Users findUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Users findUserById(Long id) {
		return repository.finduserById(id);
	}
	
	public List<Users> findUserByRole(String role) {
		return repository.findUserByRole(role);
	}
	
	public List<Users> findAllUsers() {
		return repository.findAll();
	}

}
