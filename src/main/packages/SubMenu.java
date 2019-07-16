import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubMenu {
    private WebDriver driver;

    public SubMenu(WebDriver driver)
    {
        this.driver=driver;

    }

    private By activeItem = By.xpath("//a[@class='tabs-nav__item-link tabs-nav__item-link--active']");
    private  By inActiveItem = By.xpath("//a[@class='tabs-nav__item-link ']");
    private  By listMenuItems = By.xpath("//ul[@class='tabs-nav']/li");


    public void activeMenuItem()
    {
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='tabs-nav']/li/a"));
        int size= menuList.size();
        int count=0;

        for(int i = 0; i <size; i++) {
            if (menuList.get(i).equals(activeItem)) count++;
            {
                System.out.println("size :" + size + " list item " + menuList.get(i));
            }
        }


    }
}
