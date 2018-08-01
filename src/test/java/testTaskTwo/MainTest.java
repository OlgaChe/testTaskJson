package testTaskTwo;

import Driver.MainMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

/**
 * Created by olga on 8/1/2018.
 */
public class MainTest extends MainMethods {

    String operationSystem = getProperty("os.name").toLowerCase();

    File dir = new File("src");

    File driverChromeWin = new File(dir, "chromedriver.exe");
    File driverChromeLinux = new File(dir, "chromedriverLinux64");
    File driverChromeMac = new File(dir, "chromedriverMac");


    @BeforeTest
    public void DriverChrome() throws IOException {
        System.out.println(("[TEST STARTED]"));
        System.out.println(("OS: "+ operationSystem));
        if (operationSystem.contains("win")){
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeWin));
        }else if (operationSystem.contains("nux") || operationSystem.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeLinux));
        }else if (operationSystem.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeMac));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void quit(){
        driver.close();
    }
}
