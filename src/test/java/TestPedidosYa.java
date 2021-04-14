import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FirstRestaurant;
import pageObjects.MainPage;
import pageObjects.SearchResult;

public class TestPedidosYa extends Base{
        private MainPage mainPage;
        private SearchResult searchResult;
        private FirstRestaurant firstRestaurant;

        @BeforeTest
        public void initialize(){
            driver=initializeDriver();
            driver.get("https://www.pedidosya.com.uy/");
            mainPage = new MainPage(driver);
            searchResult = new SearchResult(driver);
            firstRestaurant = new FirstRestaurant(driver);
        }

        @Test
        @Description("Explore the pedidoya page")
        @Parameters({"Address"})
        public void A_PedidosYA_page_appears(String Address) {
            mainPage.search_items(Address);
            searchResult.Show_results(Address);
            firstRestaurant.obtainRestaurantInfo();
        }

        @AfterTest
        public void closeDriver(){
            driver.close();
        }
}
