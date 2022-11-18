package RahulshettyAcademy.Resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportss {
	
	
	public static ExtentReports getReports() {
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Ecommers Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anil Ponugoti");
		//extent.setSystemInfo("Guidence", "Venu");
		
		return extent;
		
	}

}
