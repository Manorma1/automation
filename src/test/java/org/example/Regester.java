package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Regester {
    static WebDriver driver;



    public static void TypeText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public static void clickOnElement(By by,int time){
        driver.findElement(by).click();
    }
    public static long timestamp(){
        return (System.currentTimeMillis());
    }
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public  static void selectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public  static void selectFromDropDownByValue(By by, String n) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(n);
    }
    public  static void selectFromDropDownByindex(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public static String  getTextFrompage(By by,int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        return driver.findElement(by).getText();
    }

    public static void waitUntilElementToClickble(By by) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(
               ExpectedConditions.elementToBeClickable(by));

    }









    @BeforeMethod

            public static void initialiseMethode(){
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-autpmation"});

        driver = new ChromeDriver();
    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");}
         @ Test
    public static void registration() {
// implicitly wait;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click on regester;
        driver.findElement(By.linkText("Register")).click();
        //click on femail;
        clickOnElement(By.xpath("//input[@id=\"gender-female\"]"),40);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //type first  name;

             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

             TypeText(By.xpath("//input[@name=\"FirstName\"]"),"mlk");
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             //type last name;
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         TypeText(By.xpath("//input[@name=\"LastName\"]"),"dave");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //select date ofbirth
        selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"6");
        //select month;
        selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"February");
        //select year;
         selectFromDropDownByindex(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1912");
         //type email i.d
         TypeText(By.name("Email"),"Manorma+"+timestamp()+"@gmail.com");
         //type company name
         TypeText(By.id("Company"),"Mahixyz");
         //type password
         TypeText(By.id("Password"),"123456");
         //type confirm password
         TypeText(By.id("ConfirmPassword"),"123456");
         clickOnElement(By.id("register-button"),20);
         String expectedText = "Your registration completed"; // match expected and actual result;

         String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualText,expectedText);






    }
    @Test(priority = 1)
    public static void EmailaFriend(){
//use registration method;
        registration();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //click on computer
        driver.findElement(By.linkText("Computers")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


     // click on desktop;
        waitUntilElementToClickble(By.linkText("Desktops"));
        //click on picture of desktop

        clickOnElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]"),40);
        //select digital strom

        clickOnElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"),40);
        //click onemail a friend
       clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"),40);
       //type friends email;
        TypeText(By.xpath("//input[@class=\"friend-email\"]"),"man+"+timestamp()+"@gmail.com");
       //TypeText(By.xpath(""),"Manorma+"+timestamp()+"@gmail.com");
        //type massege;
        TypeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"This is a very nice product");
        //click on send email;
        clickOnElement(By.xpath("//input[@class=\"button-1 send-email-a-friend-button\"]"),20);
        String expectedText = "Your message has been sent.";
       String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualText,expectedText); // match actual and expacted result;





        


    }
    @Test(priority = 2)
    public static void Books(){

       // waitUntilElementToClickble(By.linkText("Books "));
        //click onbooks
        driver.findElement(By.linkText("Books")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //clickOnElement(By.xpath("//div[@class='page-body']//div[1]//div[1]//div[1]//a[1]//img[1]"),10);
// click on add to cart
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //click on image;
        clickOnElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[1]//a[1]//img[1]"),10);

        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div/div[2]/div[3]/div[2]/input[1]"),40);
clickOnElement(By.linkText("shopping cart"),20);


        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


       String expectedText = "Fahrenheit 451 by Ray Bradbury";
        String actualText = getTextFromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
        Assert.assertEquals(actualText, expectedText);



        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String expectedText1 = "First Prize Pies";
        String actualText1 =driver.findElement(By.linkText("First Prize Pies")).getText();
        Assert.assertEquals(actualText1,expectedText1);













    }

   // @AfterTest
   // public static void closingMethod(){
       // driver.close();
   // }
}


