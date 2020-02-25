package com.listeners;

import java.io.File;

import org.codehaus.plexus.util.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.util.JiraPolicy;
import com.util.JiraServiceProvider;

public class TestJiraListener implements ITestListener {
	
public void onTestFailure(ITestResult result) {
		
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if(isTicketReady) {
			//raise Jira Ticket
			System.out.println("Is Ticket ready for Jira : "+ isTicketReady );
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://gauravgarje.atlassian.net/", "g.gaurav2812@gmail.com", 
					"2DOmgO677Tyu2T6zvqGz0BB9", "TES");
			
			String methodName = result.getMethod().getConstructorOrMethod().getMethod().getName();
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to assertion or exception run on 17th Feb"; 
			String issueDescription = result.getThrowable().getMessage();
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			
			
			
			
			String path = "C:\\Users\\P10444427.PDCDT01GY4ZVQ1\\Downloads\\JiraInteOne-master\\JiraInteOne-master\\JiraInteTest\\Screenshots\\Createwishlist\\"+ methodName + ".png";
			
			File file = new File(path);
		
			
			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Gaurav Garje",file);
			
		
		}
	}
	

	
}
