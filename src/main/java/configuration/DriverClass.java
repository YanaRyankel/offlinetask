package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverClass {

    public static WebDriver driver = null;

    private DriverClass(){
        System.out.println("Initiating driver");
    }

    public synchronized static WebDriver getInstance(String browserName) {
        if (driver == null) {
            if (browserName.toLowerCase().contains("firefox")) {
                driver = new FirefoxDriver();
                return driver;
            }
            if (browserName.toLowerCase().contains("internet")) {
                driver = new InternetExplorerDriver();
                return driver;
            }
            if (browserName.toLowerCase().contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Mentoring\\offlineTask\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
            }}
            return driver;
        }
}
