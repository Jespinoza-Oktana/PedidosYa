package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class MainPage{

    private final WebDriver driver;
    private final String url ="https://www.pedidosya.com.uy/";

    @FindBy(xpath = "//*[@id=\"selectCity_chosen\"]/a/div/b")
    WebElement droplist;

    @FindBy(xpath = "//li[contains(text(), 'Montevideo')]")
    WebElement pickMontevideo;

    @FindBy(css = "input[name='address']")
    WebElement adress;

    @FindBy(css = "input[name='optional']")
    WebElement optinalFilter;

    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "confirm")
    WebElement acceptButton;

    @FindBy(className = "mapNotification")
    WebElement waitNotification;



    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Parameters({"Address"})
    public void searchItems(String Address) {
        droplist.click();
        pickMontevideo.click();
        adress.sendKeys(Address);
        optinalFilter.sendKeys("Pizzas");
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(waitNotification));
        acceptButton.click();
    }

    public String getUrl() {
        return url;
    }
}
