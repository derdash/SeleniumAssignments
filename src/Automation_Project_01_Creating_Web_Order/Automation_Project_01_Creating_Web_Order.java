package Automation_Project_01_Creating_Web_Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Automation_Project_01_Creating_Web_Order {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DERDASH\\Desktop\\DUO TECH\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();       //  1. Open Chrome browser
        Thread.sleep(2000);
//  2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(2000);

//  3.a Login using username Tester and password test
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        Thread.sleep(2000);

//  3.b Login using username Tester and password test
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);

//  4. Click on Order link
        String xpath = "/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a";
        String text = driver.findElement(By.xpath(xpath)).getText();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText(text)).click();
        Thread.sleep(2000);

//        5. Enter a random quantity between 1 and 100
        int r = (int) (Math.random() * 100);
        String random1_100 = "" + r;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(random1_100);
        System.out.println(r);           // just printing out for fun
        System.out.println("**********");
        Thread.sleep(2000);

//        6. Enter Customer Name as  random String of uppercase and lowercase letters with length 5 for First and Last name:
//        For example sdTFs Hsfsa
        String randonLastName = "";
        String randonName = "";
        for (int i = 0; i < 5; i++) {
            int y = (int) (Math.random() * 2);
            if (y == 0) {
                randonName += ((char) (65 + (int) (Math.random() * 26)));
                randonLastName += ((char) (97 + (int) (Math.random() * 26)));
            } else {
                randonName += ((char) (97 + (int) (Math.random() * 26)));
                randonLastName += ((char) (65 + (int) (Math.random() * 26)));
            } }

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(randonName + " " + randonLastName);
        System.out.println(randonName + " " + randonLastName); // just printing out for fu
        System.out.println("**********");
        Thread.sleep(2000);
//        7. Enter street: 8607 Westwood Center Dr
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("8607 Westwood Center Dr");

//        8. Enter City: Vienna

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Vienna");
//        9. Enter State: Virginia
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");

//        10. Enter a random 5 digit number to the zip code field
        int y = (int)(10000+ (Math.random() * 90_000));String random5 = "" + y;
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(random5);
        System.out.println(y); // just printing out for fu
        System.out.println("**********");
        Thread.sleep(2000);
//        11. Select any card type. Every time your code should select a different type.

        int cT = (int)(Math.random()*3);

        if  (cT==0){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        }else if (cT==1) {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
        }else {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
        }
        System.out.println(cT); // just printing out for fu
        System.out.println("**********");
        Thread.sleep(2000);
//        12. Enter a card number:
        int singleRandom = (int) (Math.random() * 10);
        int cfh = (int) (1000000 + (Math.random() * 9000000)); // Random 7 digits int num will first part
        int csh = (int) (1000000 + (Math.random() * 9000000)); // another 7 digits int num will second part
        String fr = "" + cfh + csh;                            // 14 digits concatenate as String (hint a -1 )

//        If you selected Visa, card number should start with 4.
        String visaCARD   = "4" + fr + singleRandom;
//        If you selected Master, card number should start with 5.
        String masterCARD = "5" + fr + singleRandom;
//        If you selected American Express, card number should start with 3.
        String amexCARD   = "3" + fr ;
//        New card number should be auto generated every time you run the test.
//                Card numbers should be 16 digits for Visa and Master, 15 for American Express.
        if  (cT==0){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(visaCARD);
        }else if (cT==1) {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(masterCARD);
        }else {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(amexCARD);
        }

        System.out.println((cT==0) ? "Visa " + visaCARD : (cT==1) ? "Master " +masterCARD : "Amex " + amexCARD); //
        System.out.println("**********");
        Thread.sleep(2000);

//        13. Enter a valid expiration date (newer than the current date)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
        LocalDateTime now = LocalDateTime.now().plusMonths(1) ;
        String dateNew = dtf.format(now);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(dateNew);
        System.out.println(dateNew);
        System.out.println("**********");
        Thread.sleep(2000);

//        14. Click on Process
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        System.out.println("Click Process");
        System.out.println("**********");
        Thread.sleep(2000);

//        15. Verify that the page contains text “New order has been successfully added”.
        String verifytext = "New order has been successfully added.";
        System.out.println(verifytext);
        System.out.println("**********");
        Thread.sleep(2000);
        System.out.println  (driver.getPageSource().contains(verifytext)? "Pass, page contains \"" + verifytext + "\"": "Fail, does not page contains \"" + verifytext + "\"");


//        Push your project to GitHub and submit your GitHub repository link

    }}



