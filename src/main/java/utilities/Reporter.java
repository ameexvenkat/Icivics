package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests{
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test, node;
	public Properties prop;
	protected static File file;
	
	public String testCaseName, testDescription, nodes, authors,category, propname;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		file = new File("./reports/"+date);
		if(!file.exists()) {
			System.out.println("Exists? "+file.exists());
			file.mkdir();
		}
		reporter = new ExtentHtmlReporter(file.toString()+"./result.html");
		reporter.config().setChartVisibilityOnOpen(false);
		reporter.config().setDocumentTitle("ICIVICS TEST REPORT");
		reporter.config().setReportName("ICIVICS AUTOMATION DASHBOARD");
		reporter.setAppendExisting(true); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName);
		//test.assignAuthor(authors);
		//test.assignCategory(category);  
	}
    
    public abstract long takeSnap();
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }

	public WebElement getProp(String propname, String locatorType, String value) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}














