package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FirstRestaurant {
    private final WebDriver driver;

    @FindBy(className = "description")
    List<WebElement> Rest_description;

    @FindBy(xpath = "//span[contains(@class, 'new_rating')]")
    List<WebElement> Rest_rating;

    @FindBy(xpath = "//h1[contains(@itemprop, 'name')]")
    WebElement Rest_name;

    public FirstRestaurant(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void obtainRestaurantInfo(){
        System.out.println("\nThe name of the restaurant is: " + Rest_name.getText());
        Allure.addAttachment("Name of the restaurant", Rest_name.getText());
        System.out.printf("\n");
        System.out.printf("%-30s %s\n", "Description", "rating");

        for (Integer i = 0; i < 3; i++) {
            System.out.printf("%-30s %s\n", Rest_description.get(i).getText(), Rest_rating.get(i).getText());
            Allure.addAttachment("The rating of "+Rest_description.get(i).getText(),Rest_rating.get(i).getText());
        }
    }


}
