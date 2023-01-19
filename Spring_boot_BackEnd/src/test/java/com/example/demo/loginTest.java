package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@ComponentScan(basePackages = "com.example.demo.service")
public class loginTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private UserRepository repo ;
	
	@Autowired
    private UserService service ;
	
	
	@Test
    public void loginUserTest() {
		Role role = Role.admin;
        Users user = new Users();
        user.setEmail("jawherguemri12@gmail.com");
        user.setPassword("1414");
        user.setRole(role);

       // Users savedUser = repo.save(user);
        
        
        Users user2 = new Users();
        user2.setEmail("jawher2222@gmail.com");
        user2.setPassword("1414");
        
        String ch = service.login(user2);
        //System.out.println("ddddddddddddddddddddd"+ch);
         
        //Users existUser = entityManager.find(Users.class, savedUser.getId());
         
        assertThat(ch).isEqualTo("admin");
        
    }

}
