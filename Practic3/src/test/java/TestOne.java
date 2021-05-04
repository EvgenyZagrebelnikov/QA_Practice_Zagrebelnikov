import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestOne {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void testFirstAttempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"card-number-field\"]/label")).click();
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText());
    }

    //*[@id="input-card-number"]

    @Test
    public void testOne_proverka_vvedennih_dannih_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("11");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2022");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("979");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("success")).click();

        assertEquals(driver.findElement(By.xpath("//*[@id='payment-item-status']/div[2]")).getText(), "Confirmed");
        assertEquals(driver.findElement(By.xpath("//*[@id='payment-item-cardholder']/div[2]")).getText(), "EVGENY EVGENY");
        assertEquals(driver.findElement(By.id("payment-item-total-amount")).getText(), "291.86");

    }

    @Test
    public void testOne_Card_number_is_not_valid_Attempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"card-number-field\"]/label")).click();
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText());
    }

    @Test
    public void testOne_Card_number_is_valid_Attempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000002");
        driver.findElement(By.xpath("//*[@id=\"card-number-field\"]/label")).click();

    }

    @Test
    public void testOne_Card_holder_is_valid_Attempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");

    }

    @Test
    public void testOne_Card_holder_is_not_valid_Attempts() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("ЕВГЕНИЙ");
        driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/label")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='card-holder-field']/div/label")).getText(), "Cardholder name is not valid");

    }

    @Test
    public void testOne_card_expires_month_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("11");
        driver.findElement(By.id("card-expires-month")).click();

    }

    @Test
    public void testOne_card_expires_year_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("11");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2022");
        driver.findElement(By.id("card-expires-year")).click();

    }

    @Test
    public void testOne_input_card_cvc_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("11");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2022");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("000");

    }

    @Test
    public void testOne_card_cvc_is_not_valid_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("EVGENY EVGENY");
        driver.findElement(By.id("input-card-holder")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("11");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2022");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("00");
        driver.findElement(By.xpath("//*[@id=\"card-cvc-field\"]/label")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='card-cvc-field']/div/label")).getText(), "CVV2/CVC2/CAV2 is not valid");

    }

    @Test
    public void test_Card_data_not_Valid_TestCase() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("0000000000000005");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("ЕВГЕНИЙ");
        driver.findElement(By.id("input-card-holder")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2021");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("00");
        driver.findElement(By.id("action-submit")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='card-holder-field']/div/label")).getText(), "Cardholder name is not valid");
        assertEquals(driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText(), "Card number is not valid");
        assertEquals(driver.findElement(By.xpath("//*[@id='card-cvc-field']/div/label")).getText(), "CVV2/CVC2/CAV2 is not valid");
        assertEquals(driver.findElement(By.xpath("//*[@id='card-expires-field']/div/label")).getText(), "Invalid date");

    }

    //@After
    public void tearDown() {
        driver.quit();
    }
}