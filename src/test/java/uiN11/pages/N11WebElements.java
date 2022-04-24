package uiN11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiN11.utilities.Driver;

import java.util.List;

public class N11WebElements {


    public N11WebElements() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath= "//*[text()='n11.com - Hayat Sana Gelir']")
    public WebElement n11Title;


    @FindBy(xpath ="//div[@class='btn btnBlack btnBlack-loc-info']")
    public WebElement konumGec;


    @FindBy(xpath ="(//button[@class='dn-slide-deny-btn'])[1]")
    public WebElement bilgiEkranGec;


    @FindBy(xpath ="//div[@class='hBotMenu']//li[5]" )
    public WebElement magazalarMenu;

    @FindBy(xpath="//a[@title='Mağazaları Gör']" )
    public WebElement magazalariGor;

    @FindBy(xpath="//div[@id='contentSellerList']/div[@class='container']//div[@class='tab']/ul//h3[.='Tüm Mağazalar']" )
    public WebElement tumMagazalar;

    @FindBy(xpath="//span[@class='active selected']" )
    public WebElement aHarfliTumMagazalar;

    @FindBy(xpath="//div[@id='contentSellerList']/div[@class='container']/div[@class='tabList']//i[.='\"A\"']" )
    public WebElement aIcerenSonuclar;

    @FindBy(xpath ="//div[@class='sellerListHolder']//ul[1])[4]/li")
    public List<WebElement> aHarfliMagazalar;

    @FindBy(xpath ="//input[@id='searchData']" )
    public WebElement searchBox;

    @FindBy(xpath ="//select[@id='sortingType']" )
    public WebElement yorumSiralama;

    @FindBy(xpath ="//div[@class='resultText ']" )
    public WebElement resultText;

    @FindBy(xpath ="//label[@id='freeShipmentOption']/span[.='Ücretsiz Kargo']" )
    public WebElement ucretsizKargo;

    @FindBy(xpath ="//div[@id='view']/ul/li[1]/div//a")
    public WebElement ilkUrun;

    @FindBy(xpath ="//div[@id='view']/ul/li[28]/div//a")
    public WebElement sonUrun;

    @FindBy(xpath ="//div[@class='button-group']" )
    public WebElement sepetEkleButton;

    //@FindBy(xpath ="//div[@id='skuArea']//select" )
    //public WebElement urunRenkSecme;

   // @FindBy(xpath ="//a[@class='btn btnGrey btnAddBasket']")
   // public WebElement sepetEkle2Button;

    @FindBy(xpath ="//i[@class='icon iconBasket']" )
    public WebElement sepetButton;

    @FindBy(xpath ="//span[@class='btn btnBlack']" )
    public WebElement misafirMetni;

    @FindBy(xpath =" (//span[@class='spinnerUp spinnerArrow'])[2]" )
    public WebElement urunSayisiArtirma;

    @FindBy(xpath ="//span[@id='js-buyBtn']" )
    public WebElement satinAlButon;

    @FindBy(xpath ="//a[@class='btn-continue']" )
    public WebElement misafirOdemeEkran;

    @FindBy(xpath ="//input[@id='guestEmail']" )
    public WebElement mailAdresi;

    @FindBy(xpath ="//input[@id='gsmNumber']" )
    public WebElement telefonNo;

    @FindBy(xpath ="//span[@class='confirmBtn btn btnGreen']" )
    public WebElement telefonDogrula;
}
