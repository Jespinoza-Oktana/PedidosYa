package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FirstRestaurantPage {
    private final WebDriver driver;

    @FindBy(className = "description")
    List<WebElement> listDescription;

    @FindBy(xpath = "//span[contains(@class, 'new_rating')]")
    List<WebElement> listRestaurantRating;

    @FindBy(xpath = "//h1[contains(@itemprop, 'name')]")
    WebElement restName;

    public FirstRestaurantPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void obtainRestaurantInfo(){
        System.out.println("\nThe name of the restaurant is: " + restName.getText());
        Allure.addAttachment("Name of the restaurant", restName.getText());
        System.out.printf("\n");
        System.out.printf("%-30s %s\n", "Description", "rating");

        for (Integer i = 0; i < 3; i++) {
            System.out.printf("%-30s %s\n", listDescription.get(i).getText(), listRestaurantRating.get(i).getText());
            Allure.addAttachment("The rating of "+ listDescription.get(i).getText(), listRestaurantRating.get(i).getText());
        }
    }


}
