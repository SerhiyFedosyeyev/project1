import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import packages.Fixtures;

import java.util.concurrent.TimeUnit;

//import sun.jvm.hotspot.runtime.Thread;

public class MainClass
{
    static WebDriver driver;
    static WebDriverWait wait5;
    static WebDriverWait wait10;
    @FindBy(xpath = "//ul[@class='tabs-nav']/li/a")
    private WebElement menuLink;


    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Drivers\\chromedriver.exe");
        driver = new FirefoxDriver();
       // driver = new ChromeDriver();
        wait5 = (new WebDriverWait(driver, 5));
        wait10 = (new WebDriverWait(driver, 10));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //  SchemaValidatorClass smth= new SchemaValidatorClass();
      //smth.ampValidation(driver);
      //smth.schemaValidator(driver);
        driver.get("https://beta-stage.mancity.com/fixtures");
        Fixtures fix = new Fixtures(driver);
        System.out.println(fix.getCalendarText()+" Calend text");
        SubMenu menu =new SubMenu(driver);
        menu.activeMenuItem();
        wait5.until(ExpectedConditions.attributeContains(By.xpath("//ul[@class='tabs-nav']/li/a"),"class", "tabs-nav__item-link--active"));
        driver.quit();



    }

}
