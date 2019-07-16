package packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fixtures {
    private WebDriver driver;

    public Fixtures(WebDriver driver) {
        this.driver = driver;

    }
    private By getTitle = By.xpath("//h1[@class='sub-header__heading']");
    private By sponsorText = By.xpath("//span[@class='sub-header__sponsor-text shown-lg']");
    private By sponsorIcon = By.xpath("//img[@class='sub-header__sponsor-img']");
    private By calendarText = By.xpath("//div[@class='month-term__heading']//span");
    private By ticketInfo = By.xpath("//div[@class='ticket-info']");

    public  String getPageTitle()
    {
        return driver.findElement(getTitle).getText();
    }

    public String getSponsorText()
    {
        return driver.findElement(sponsorText).getText();
    }

    public String getCalendarText()
    {
        return driver.findElement(calendarText).getText();
    }


    public String getTicketInfo()
    {
        return driver.findElement(ticketInfo).getText();
    }

    public Boolean getSponsorIcon()
    {
        return driver.findElement(sponsorIcon).isDisplayed();
    }



}
