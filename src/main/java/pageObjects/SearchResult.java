package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.util.List;

public class SearchResult {
    private final WebDriver driver;

    @FindBy(className = "found")
    WebElement total_results;

    @FindBy(className = "arrivalName")
    List<WebElement> pizzaStores;

    @FindBy(xpath = "//span[contains(text(), 'Descubrir')]")
    WebElement filter_descubir;

    @FindBy(xpath = "//a[contains(@data-dropdown, 'drop1')]")
    WebElement sort_droplist;

    @FindBy(linkText = "Alfabéticamente")
    WebElement sort_alfabeticamente;

    @FindBy(xpath = "//a[contains(text(), 'Bar Castrobó')]")
    List<WebElement> first_restaurant;

    @FindBy(xpath = "//i[contains(@class, 'rating-points')]")
    List<WebElement> rating;

    public SearchResult(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Parameters({"Address"})
    public void Show_results(String Address){
        System.out.println("The Page with no filter selected");
        this.obtain_Total_Search_results(Address);
        this.printResults(pizzaStores.size());
        filter_descubir.click();
        sort_droplist.click();
        sort_alfabeticamente.click();
        System.out.println("\nThe Page with 1 filter selected");
        this.obtain_Total_Search_results(Address);
        this.printResults(pizzaStores.size());
        System.out.printf("\n");
        System.out.printf("%-50s %s\n", "Restaurant", "Star rating");
        for (Integer i = 0; i < pizzaStores.size(); i++) {
            System.out.printf("%-50s %s\n", pizzaStores.get(i).getText(), rating.get(i).getText());
        }

        first_restaurant.get(0).click();
    }

    private void obtain_Total_Search_results(String Address) {
        int number_size= Address.length()+14;
        String total_number= total_results.getText();
        String total_rest =total_number.substring(0,total_number.length()-number_size);
        System.out.println("The total number of results are : " + total_rest);
        Allure.addAttachment("The total number of results:", total_rest);
    }
    public void printResults(Integer stores){
        System.out.println("The results for this page are : " + stores);
        Allure.addAttachment("The results for this page are", String.valueOf(stores));
    }


}
