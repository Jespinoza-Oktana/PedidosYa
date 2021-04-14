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
    WebElement pick_montevideo;

    @FindBy(css = "input[name='address']")
    WebElement adress;

    @FindBy(css = "input[name='optional']")
    WebElement optinal_filter;

    @FindBy(id = "search")
    WebElement search_button;

    @FindBy(id = "confirm")
    WebElement accept_button;

    @FindBy(className = "mapNotification")
    WebElement waitNotification;



    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Parameters({"Address"})
    public void search_items(String Address) {
        droplist.click();
        pick_montevideo.click();
        adress.sendKeys(Address);
        optinal_filter.sendKeys("Pizzas");
        search_button.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(waitNotification));
        accept_button.click();
    }


    public WebElement getDroplist() {
        return droplist;
    }

    public String getUrl() {
        return url;
    }
}
