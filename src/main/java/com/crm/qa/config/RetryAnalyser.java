package com.crm.qa.config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class RetryAnalyser implements IRetryAnalyzer {
int counter=0;
int limit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
