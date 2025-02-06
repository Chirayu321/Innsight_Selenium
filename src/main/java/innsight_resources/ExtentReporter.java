package innsight_resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporter {
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir") +"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Innsight");
		reporter.config().setDocumentTitle("Title");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Chirayu Dutt");
		extent.createTest(path);
		return extent;
	}

}
