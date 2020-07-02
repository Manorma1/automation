package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Task_3 {
     static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Soft\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-autpmation"});

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Electronics")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@alt=\"Picture for category Cell phones\"] ")).click();

        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]//div[3]/div[2]/input[1] ")).click();
        driver.findElement(By.linkText("HTC One Mini Blue")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       driver.findElement(By.xpath("//input[@ id=\"add-to-cart-button-19\"]")).click();




       // driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]//div[3]/div[2]/input[1]")).click();

        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();

        String pageText = driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).getText();
        System.out.println(pageText);

       pageText= driver.findElement(By.linkText("HTC One Mini Blue")).getText();
       System.out.println(pageText);



















    }










}
