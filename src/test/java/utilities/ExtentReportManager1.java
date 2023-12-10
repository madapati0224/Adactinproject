package utilities;


	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	import testBase.BaseClass;

	public class ExtentReportManager1 implements ITestListener {
		
	public ExtentSparkReporter Sparkreporter;  //UI of the report
		public ExtentReports extent; //commom information like Title ,name of the test,Theme etc.,
		public ExtentTest test;      //create entery in the report and update testcase pass or fail
		String repName;
		
		public void onStart(ITestContext context)  //1 time should execute at begining
		{
			String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// Time stamp
			repName="Test-Report-"+timestamp+".html";
		//UI of the report
			
			Sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);//Location of the report to generate 
			Sparkreporter.config().setDocumentTitle("Automation Testing"); //Title
			Sparkreporter.config().setReportName("Functional Testing"); //Name of the Report
			//Sparkreporter.config().setTheme(Theme.STANDARD); //Theme
			Sparkreporter.config().setTheme(Theme.DARK); //Theme

		//commom information to the Report
			
			extent=new ExtentReports();
			extent.attachReporter(Sparkreporter);
			extent.setSystemInfo("computer name","localhost");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Tester name","Girija");
			extent.setSystemInfo("OS","Windows 10");
			extent.setSystemInfo("Browser","Chrome");
			
		}

		public void onTestSuccess(ITestResult result)
		{
			test= extent.createTest(result.getName()); //create entry on the Report
			test.log(Status.PASS, "Test is passed:"+result.getName()); //update the status  of test
			try {
				String imgpath=new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgpath);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		}
		public void onTestFailure(ITestResult result)
		{
			test= extent.createTest(result.getName());
			test.log(Status.FAIL, "Test is failed:"+result.getName());
			test.log(Status.FAIL,"Test is failed becuase:"+result.getThrowable());
		}
		public void onTestSkipped(ITestResult result)
		{
			test= extent.createTest(result.getName());
			test.log(Status.SKIP, "Test is skipped:"+result.getName());
			test.log(Status.SKIP,"Test is skipped becuase:"+result.getThrowable());
		}
		public void onFinish(ITestContext context)
		{
			extent.flush();
		}


}
