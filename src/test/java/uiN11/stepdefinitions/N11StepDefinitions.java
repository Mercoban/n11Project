package uiN11.stepdefinitions;

import io.cucumber.java.ca.I;
import io.cucumber.java.en.*;
import org.apache.groovy.json.internal.IO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiN11.pages.N11WebElements;
import uiN11.utilities.ConfigReader;
import uiN11.utilities.Driver;
import uiN11.utilities.Log;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class N11StepDefinitions {

    N11WebElements n11Page = new N11WebElements();
    Actions actions=new Actions(Driver.getDriver());
    Logger log = (Logger) LogManager.getLogger(N11StepDefinitions.class);


    @Given("user goes to N11 Home Page")
    public void user_goes_to_n11_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
        log.info("N11 Ana Sayfa açıldı");

    }

    @Then("user verifies {string}")
    public void userVerifies(String arg0) {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "n11.com - Hayat Sana Gelir";
        Assert.assertEquals("Condition true", actualTitle, expectedTitle);
        log.info("N11 Ana Sayfa açıldığı doğrulandı");

    }

    @Then("user clicks Magazalar menu")
    public void userClicksMagazalarMenu() throws InterruptedException {
        n11Page.konumGec.click();
        Thread.sleep(5000);
        n11Page.bilgiEkranGec.click();
        log.info("İstemdışı açılan pencereler geçildi");
        n11Page.magazalarMenu.click();
        n11Page.magazalariGor.click();
        log.info("Mağazalar menüsü seçildi");

    }


    @Then("user clicks Tum Magazalar menu")
    public void userClicksTumMagazalarMenu() {
        n11Page.tumMagazalar.click();
        log.info("Tüm Mağazalar menüsü seçildi");
    }


    @And("user selects A harfindeki tum magazalar")
    public void userSelectsAHarfindekiTumMagazalar() {

        n11Page.aHarfliTumMagazalar.click();
        log.info("A harfine tıklanarak 'A' iceren mağazalar geldi");
        n11Page.aIcerenSonuclar.isDisplayed();
        log.info("A harfi iceren sonuçlar yazısı doğrulandı ");

    }

    @Then("user verifies the title of all subcategories")
    public void userVerifiesTheTitleOfAllSubcategories() {


        List<WebElement> allElements = Driver.getDriver().findElements(By.xpath("(//div[@class='sellerListHolder']//ul[1])[4]/li"));

        System.out.println("Number of allElements:" + allElements.size());

        for (int i = 0; i < allElements.size(); i++) {
            System.out.println(allElements.get(i).getText());
            log.info("A harfi iceren tüm mağazalar yazdırıldı ");
        }


    }

    @And("{string} icin arama yapar")
    public void icinAramaYapar(String arananKelime) throws InterruptedException {
        n11Page.konumGec.click();
        Thread.sleep(5000);
        n11Page.bilgiEkranGec.click();
        log.info("İstemdışı açılan pencereler geçildi");
        n11Page.searchBox.click();
        n11Page.searchBox.sendKeys(arananKelime+ Keys.ENTER);
        log.info("İstenen kelime arandı");

    }

    @Then("sonucun {string} icerdigini test eder")
    public void sonucunIcerdiginiTestEder(String arg0) {
    Assert.assertTrue(n11Page.resultText.isDisplayed());

        log.info("Araması yapılan kelime doğrulandı");

    }

    @Then("Gelen sonuclar yorum sayisina göre siralanir.")
    public void gelenSonuclarYorumSayisinaGöreSiralanir() {

        n11Page.yorumSiralama.click();
        Select select=new Select(Driver.getDriver().findElement(By.xpath("(//select[@id='sortingType'])")));
        select.selectByVisibleText("Yorum sayısı");
        log.info("Aranan ürün Yorum sayısına göre sıralandı");

    }

    @Then("Gelen urunlerden ucretsiz kargo olanlar listelenir.")
    public void gelenUrunlerdenUcretsizKargoOlanlarListelenir() {
     n11Page.ucretsizKargo.click();
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
        log.info("Ücretsiz Kargo olanlar sıralandı");

    }

    @Then("Gelen sonuclardan ilk sayfadaki birinci ve sonuncu urun sepete eklenir.")
    public void gelenSonuclardanIlkSayfadakiBirinciVeSonuncuUrunSepeteEklenir() throws InterruptedException {

        n11Page.ilkUrun.click();
        Thread.sleep(3000);
        n11Page.sepetEkleButton.click();
        Thread.sleep(3000);
        log.info("Sayfadaki ilk  ürün seçilerek sepete eklendi");
        Driver.getDriver().navigate().to("https://www.n11.com/telefon-ve-aksesuarlari/cep-telefonu-aksesuarlari?q=kulakl%C4%B1k&srt=REVIEWS&isf=1&ref=auto");
        Thread.sleep(3000);
        n11Page.sonUrun.click();
       //  n11Page.urunRenkSecme.click();
       // Select select=new Select(Driver.getDriver().findElement(By.xpath("//div[@id='skuArea']//select")));
       // select.selectByVisibleText("Beyaz");
        n11Page.sepetEkleButton.click();
        log.info("Sayfadaki son  ürün seçilerek sepete eklendi");
    }



    @Then("Sepette en ucuz urun adedi {int} yapılır ve misafir kullanıcı olarak odemeye gecilir.")
    public void sepetteEnUcuzUrunAdediYapılırVeMisafirKullanıcıOlarakOdemeyeGecilir(int arg0) {


    //    List<WebElement> beforePrice = Driver.getDriver().findElements(By.className(".prodPrice__text"));
    //    List<Double> beforePriceList = new ArrayList<>();

      //  Collections.sort(beforePriceList);
      //  System.out.println("beforePriceList = " + beforePriceList);
        n11Page.sepetButton.click();
        n11Page.misafirMetni.click();
        n11Page.urunSayisiArtirma.click();
        log.info("Sepetteki ucuz olan ürün adedi 2 yapıldı");
        n11Page.satinAlButon.click();
        n11Page.misafirOdemeEkran.click();
        n11Page.mailAdresi.sendKeys(ConfigReader.getProperty("eMail"));
        n11Page.telefonNo.click();
        n11Page.telefonNo.sendKeys(ConfigReader.getProperty("telefonNo"));
        actions.sendKeys(Keys.TAB).perform();
        n11Page.telefonDogrula.click();
        log.info("Satın alma bölümüne geçilerek misafir kullanıcı olarak ödeme ekranına geçildi");


    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {


    }

}





