package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
            @DataProvider istedigimiz test method'una test datasi saglamak icin kullanilir
            sadece bir sdarti vardir
            iki katli bir Object array'i dondurmelidir
         */

        Object[][] amazonAranacakKelimelerArrayi=
                {{"Nutella"}, {"Java"}, {"Apple"}, {"Samsung"}, {"armut"}};

        return amazonAranacakKelimelerArrayi;
    }

    // amazona gidelim
    // Nutella, Java, Apple, Samsung, armut kelimeleri icin arama yapalim
    // sonuclarin bu kelimeleri icerdigini test edelim




    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage= new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);

        String actualSonucYazisi= amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));

        Driver.closeDriver();
    }
}
