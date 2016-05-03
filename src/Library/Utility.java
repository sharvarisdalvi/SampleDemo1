package Library;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String captureScreenshot(WebDriver driver, String screenshotName)
	
	{
	try{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File Scource=ts.getScreenshotAs(OutputType.FILE);
		String dest="C:\\Users\\sharvari.bhosale\\Desktop\\Desktop\\screenshot"+screenshotName+".png";
		File destination=new File(dest);
		FileUtils.copyFile(Scource, destination);
		System.out.println("Scrrenshot Taken");
		
		return dest;
		
	}
		catch (Exception e){
			System.out.println("Scrrenshot Taken"+e.getMessage());
			return e.getMessage();
		}
	
	}
}
