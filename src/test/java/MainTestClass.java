import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainTestClass {

  private packages.Fixtures fixt;
  private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Drivers\\chromedriver.exe");
        driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void closeBrowser()
    {
        driver.quit();

    }

    @Test
    public void titleChecking()
    {

     driver.get("https://beta-stage.mancity.com/fixtures");
     fixt = new packages.Fixtures(driver);
     Assert.assertEquals("FIXTURES",fixt.getPageTitle());
     Assert.assertEquals("BROUGHT TO YOU BY",fixt.getSponsorText());
     Assert.assertEquals("TICKET INFO",fixt.getTicketInfo());
     Assert.assertEquals("Add fixtures to your calendar",fixt.getCalendarText());
     Assert.assertTrue(fixt.getSponsorIcon());

    }


    @Test
    @Ignore
    public void ticketInfo()
    {
        Assert.assertEquals("TICKET INFO",fixt.getSponsorIcon());
    }


}
