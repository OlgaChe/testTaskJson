package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Driver.MainMethods;


/**
 * Created by olga on 8/1/2018.
 */
public class TestPage extends MainMethods {

    @FindBy(xpath = "/html/body/pre")
    public WebElement jsonFile;

    public TestPage() {

        PageFactory.initElements(driver, this);
    }

}
