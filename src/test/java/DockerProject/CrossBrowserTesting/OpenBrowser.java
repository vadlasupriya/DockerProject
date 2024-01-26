package DockerProject.CrossBrowserTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	WebDriver driver;
	
  @Parameters("Browser")
  @Test
  public void BrowserInit(String browser) throws MalformedURLException, InterruptedException {
	  
	  switch (browser) {
		case "chrome":
			
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);	
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
			System.out.println("Connection established in Chrome browser");
			break;
		case "firefox":
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options1);
			System.out.println("Connection established in Firefox browser");
			break;
			
		default:
			EdgeOptions options2 = new EdgeOptions();
			options2.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options2);
			System.out.println("Connection established in Edge browser");
			break;
		}
	  
	  driver.get("https://www.amazon.in/");
	  Thread.sleep(3000);
	  String title= driver.getTitle();
	  if(title.contains("Online Shopping in India")) {
		  
		  System.out.println("Test Successfull in " + browser + " browser");
		  
	  }
	  
  }
}
