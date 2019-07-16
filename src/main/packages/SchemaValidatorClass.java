package packages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.jvm.hotspot.runtime.Thread;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchemaValidatorClass
{
 private WebDriver driver;


        static String[] ampPages = new String[]{
                "https://mancity.com/fixtures",
                "https://amp-uat.mancity.com/fixtures",
                "https://amp-uat.mancity.com/fixtures/mens",
                "https://amp-uat.mancity.com/fixtures/womens",
                "https://amp-uat.mancity.com/fixtures/eds",
                "https://amp-uat.mancity.com/fixtures/academy",
                "https://amp-uat.mancity.com/results",
                "https://amp-uat.mancity.com/results/mens",
                "https://amp-uat.mancity.com/results/womens",
                "https://amp-uat.mancity.com/results/eds",
                "https://amp-uat.mancity.com/results/academy",
                "https://amp-uat.mancity.com/tables",
                "https://amp-uat.mancity.com/tables/mens",
                "https://amp-uat.mancity.com/tables/womens",
                "https://amp-uat.mancity.com/tables/eds",
                "https://amp-uat.mancity.com/tables/academy",
                "https://amp-stage.mancity.com/citynow",
                "https://amp-stage.mancity.com/fixtures",
                "https://amp-stage.mancity.com/fixtures/mens",
                "https://amp-stage.mancity.com/fixtures/womens",
                "https://amp-stage.mancity.com/fixtures/eds",
                "https://amp-stage.mancity.com/fixtures/academy",
                "https://amp-stage.mancity.com/results",
                "https://amp-stage.mancity.com/results/mens",
                "https://amp-stage.mancity.com/results/womens",
                "https://amp-stage.mancity.com/results/eds",
                "https://amp-stage.mancity.com/results/academy",
                "https://amp-stage.mancity.com/tables",
                "https://amp-stage.mancity.com/tables/mens",
                "https://amp-stage.mancity.com/tables/womens",
                "https://amp-stage.mancity.com/tables/eds",
                "https://amp-stage.mancity.com/tables/academy",
                "https://amp.mancity.com/players",
                "https://amp.mancity.com/players/womens",
                "https://amp.mancity.com/players/eds",
                "https://amp.mancity.com/players/academy",
                "https://amp.mancity.com/players/mens",
                "https://amp-stage.mancity.com/fr/philippe-sandler",
                "https://amp-stage.mancity.com/philippe-sandler",
                "https://amp-stage.mancity.com/en/profile/lara-miller",
                "https://amp-stage.mancity.com/en/profile/colin-r%C3%B6sler",
                "https://amp.mancity.com/fixtures",
                "https://amp.mancity.com/fixtures/mens",
                "https://amp.mancity.com/fixtures/womens",
                "https://amp.mancity.com/fixtures/eds",
                "https://amp.mancity.com/fixtures/academy",
                "https://amp.mancity.com/results",
                "https://amp.mancity.com/results/mens",
                "https://amp.mancity.com/results/womens",
                "https://amp.mancity.com/results/eds",
                "https://amp.mancity.com/results/academy",
                "https://amp.mancity.com/tables",
                "https://amp.mancity.com/tables/mens",
                "https://amp.mancity.com/tables/womens",
                "https://amp.mancity.com/tables/eds",
                "https://amp.mancity.com/tables/academy"

        };
    static String[] envoroment = {
            "https://beta-stage.mancity.com/fixtures",
            "https://beta-stage.mancity.com/results",
            "https://beta-stage.mancity.com/tables",
            "https://beta-uat.mancity.com/fixtures",
            "https://beta-uat.mancity.com/results",
            "https://beta-uat.mancity.com/tables",
            "https://mancity.com/fixtures",
            "https://mancity.com/results",
            "https://mancity.com/tables"
    };

     //AMP Vailidator
    public void ampValidation(WebDriver driver)
    {
        this.driver = driver;
        for(int i=0; i<ampPages.length; i++)
        {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://validator.ampproject.org/");
            driver.findElement(By.xpath("//div[@id='labelAndInputContainer']/input[@id='input'][1]")).sendKeys(ampPages[i]);
            driver.findElement(By.xpath("//paper-button[@id=\"validateButton\"]")).click();
            driver.findElements(By.xpath("//paper-listbox[@id='listbox']/paper-item"));
            String status = driver.findElement(By.xpath("//div[@class='ampproject-result style-scope webui-statusbar']/span")).getText();
            System.out.println(ampPages[i] + " " + status);
        }
    }


    //Schema Validation
    public void  schemaValidator(WebDriver driver)
    {
        this.driver = driver;
        for(int i=0; i<envoroment.length; i++) {

            driver.get("https://search.google.com/structured-data/testing-tool/u/0/#url=" + envoroment[i]);
            //driver.findElement(By.xpath("//input[@class='mdl-textfield__input' and @id='new-test-url-input']")).sendKeys(url);
            //driver.findElement(By.xpath("//button[@id='new-test-submit-button']")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.findElements(By.xpath("//ul[@class='mdl-list']/li"));
            System.out.println(envoroment[i] + " Found " + driver.findElements(By.xpath("//ul[@class='mdl-list']/li")).size() + " schema");
            int x = 0;
            List<WebElement> schemaList = driver.findElements(By.xpath("//ul[@class='mdl-list']/li"));
            while (x < schemaList.size()) {
                System.out.println(schemaList.get(x).getText());
                x++;
            }

        }

    }


}
