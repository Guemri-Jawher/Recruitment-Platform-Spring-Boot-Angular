package com.example.demo.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * To run cucumber test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberTest {

}
