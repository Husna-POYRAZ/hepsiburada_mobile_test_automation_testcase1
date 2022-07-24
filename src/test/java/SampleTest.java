import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {
    /* TEST CASE
    • Uygulama açılır
    • Anasayfada Konum alanına tıklanır.
    • İl, ilçe ve mahalle seçilir ve kaydet butonuna Kklanır.
    • Konumunuz Kaydedildi popup’ı kontrol edilir.
    • Tab bar üzerinden kategoriler tabına tıklanır.
    • Herhangi bir kategori seçilip listeleme sayfasına yönlenilir.
    • Listeleme sayfasında Yarın Kapında alanında gelen il bilgisi ile anasayfada seçilen il bilgisinin
    aynı olduğu kontrol edilir.
     */
    private AndroidDriver driver;
    public WebDriverWait wait;

    By closebtn = By.id("com.pozitron.hepsiburada:id/com_braze_inappmessage_modal_close_button");
    By location = By.id("com.pozitron.hepsiburada:id/textViewTitle");
    By citySelector = By.id("com.pozitron.hepsiburada:id/citySelectorView");
    By city = By.xpath("//android.widget.TextView[@content-desc=\"İlçe seçin\"]");
    By townSelector = By.id("com.pozitron.hepsiburada:id/townSelectorView");
    By town = By.xpath("//android.widget.TextView[@content-desc=\"Mahalle seçin\"]");
    By districtSelector = By.id("com.pozitron.hepsiburada:id/districtSelectorView");
    By district = By.id("com.pozitron.hepsiburada:id/tvOneProvinceSelectBox");
    By savebtn = By.id("com.pozitron.hepsiburada:id/button");
    /*
    MobileElement element = (MobileElement) driver.findElementByXPath("com.pozitron.hepsiburada:id/com_braze_inappmessage_modal_frame");
    String message1 = element.getText();
    String message2 = "Konumunuz kaydedildi.";
     */
    By categorybtn = By.id("com.pozitron.hepsiburada:id/nav_graph_category");
    By phone_category = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.TextView");
    By android_phone = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.ImageView");
    By xiaomi_phone = By.xpath("//android.widget.ImageView[@content-desc=\"xiaomi\"]");
    By add_btn = By.xpath("(//android.widget.Button[@content-desc=\"Sepete Ekle\"])[1]");
    By add = By.id("com.pozitron.hepsiburada:id/atcb_product_variant");

    public void scroll(int fromx, int fromy, int tox, int toy){
        TouchAction  action =new TouchAction(driver);
        action.press(PointOption.point(fromx, fromy))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(tox, toy)).release().perform();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "11 RP1A.200720.011");
        desiredCapabilities.setCapability("appium:deviceName", "Redmi Note 8 Pro");
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appium:udid", "wos4w4rojfbugqs4");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Dell\\Documents\\MOBVEN\\apk\\Hepsiburada_ Online Alışveriş_5.4.0_apkcombo.com.apk");
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver,15);
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
        //scroll(945, 1460,922, 1453);
        //scroll(930, 665, 884, 669);
        wait.until(ExpectedConditions.visibilityOfElementLocated(closebtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(citySelector)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(townSelector)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(town)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(districtSelector)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(district)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(savebtn)).click();

        //Assert.assertEquals(message1,message2,"Doğrulama Başarılı!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(categorybtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone_category)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(android_phone)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xiaomi_phone)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(add_btn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(add)).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

