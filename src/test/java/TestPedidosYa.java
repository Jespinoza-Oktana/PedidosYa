import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FirstRestaurantPage;
import pageObjects.MainPage;
import pageObjects.SearchResultPage;

public class TestPedidosYa extends Base{
        private MainPage mainPage;
        private SearchResultPage searchResultPage;
        private FirstRestaurantPage firstRestaurantPage;

        @BeforeTest
        public void initialize(){
            driver=initializeDriver();
            mainPage = new MainPage(driver);
            searchResultPage = new SearchResultPage(driver);
            firstRestaurantPage = new FirstRestaurantPage(driver);
            driver.get(mainPage.getUrl());
        }

        @Test
        @Description("Explore the pedidoya page")
        @Parameters({"Address"})
        public void testPedidosYa(String Address) {
            mainPage.searchItems(Address);
            searchResultPage.showResults(Address);
            firstRestaurantPage.obtainRestaurantInfo();
        }

        @AfterTest
        public void closeDriver(){
            driver.quit();
        }
}
