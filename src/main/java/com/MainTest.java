package com;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


public class MainTest {

public static void main(String[] args) {
// TODO Auto-generated method stub
	        TestNG testng = new TestNG();
	        List<String> suites = Lists.newArrayList();
	        suites.add("/src/test/resources/testNG.xml");
	        testng.setTestSuites(suites);
	        testng.run();
   }

}