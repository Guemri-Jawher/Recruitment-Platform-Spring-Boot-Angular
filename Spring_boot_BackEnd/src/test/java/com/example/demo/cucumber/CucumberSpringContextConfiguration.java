package com.example.demo.cucumber;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.BackEndForProjetApplication;

import io.cucumber.java.Before;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = BackEndForProjetApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);
	

	  /**
	   * Need this method so the cucumber will recognize this class as glue and load spring context configuration
	   */
	  @Before
	  public void setUp() {
	    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	  }

}
