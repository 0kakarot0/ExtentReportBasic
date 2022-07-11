package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    private WebDriver driver;

    private By searchTextBox = By.name("q");
    private By searchButton = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchQuery(String searchQuery){
        driver.findElement(searchTextBox).sendKeys(searchQuery);
    }

    public void clickOnGoogleSearchButton(){
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
    }
}
