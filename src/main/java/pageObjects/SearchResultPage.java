package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;

    @FindBy(className = "found")
    WebElement totalResults;

    @FindBy(className = "arrivalName")
    List<WebElement> pizzaStores;

    @FindBy(xpath = "//span[contains(text(), 'Descubrir')]")
    WebElement filterFind;

    @FindBy(xpath = "//a[contains(@data-dropdown, 'drop1')]")
    WebElement sort_droplist;

    @FindBy(linkText = "Alfabéticamente")
    WebElement alphabeticalSort;

    @FindBy(xpath = "//a[contains(text(), 'Bar Castrobó')]")
    List<WebElement> firstRestaurant;

    @FindBy(xpath = "//i[contains(@class, 'rating-points')]")
    List<WebElement> listRating;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Parameters({"Address"})
    public void showResults(String Address){
        System.out.println("The Page with no filter selected");
        obtainTotalSearchresults(Address);
        printResults(pizzaStores.size());
        filterFind.click();
        sort_droplist.click();
        alphabeticalSort.click();
        System.out.println("\nThe Page with 1 filter selected");
        obtainTotalSearchresults(Address);
        printResults(pizzaStores.size());
        System.out.printf("\n");
        System.out.printf("%-50s %s\n", "Restaurant", "Star rating");

       // for(WebElement pizza :pizzaStores){
         //   System.out.printf("%-50s %s\n", pizza.getText(), rating.get(0).getText());

        //}

        for (Integer i = 0; i < pizzaStores.size(); i++) {
           System.out.printf("%-50s %s\n", pizzaStores.get(i).getText(), listRating.get(i).getText());
       }

        firstRestaurant.get(0).click();
    }

    private void obtainTotalSearchresults(String Address) {
        int number_size= Address.length()+14;
        String total_number= totalResults.getText();
        String total_rest =total_number.substring(0,total_number.length()-number_size);
        System.out.println("The total number of results are : " + total_rest);
        Allure.addAttachment("The total number of results:", total_rest);
    }
    public void printResults(Integer stores){
        System.out.println("The results for this page are : " + stores);
        Allure.addAttachment("The results for this page are", String.valueOf(stores));
    }


}
