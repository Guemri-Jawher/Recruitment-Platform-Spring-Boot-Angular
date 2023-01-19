package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestConfiguration
@TestPropertySource
public class Mysql_CucumberTest {
	
	public class MysqlConfiguration {
		
		@Value("my-projet-angular-spring")
		private String Mysql ;
		
		@Bean
		public MysqlClient mysqlClient() {
			return MysqlClients.create("mysql://localhost:3306");
		}
		
		
	}

}
