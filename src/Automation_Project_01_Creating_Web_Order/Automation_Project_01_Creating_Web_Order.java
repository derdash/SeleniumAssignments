package Automation_Project_01_Creating_Web_Order;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Automation_Project_01_Creating_Web_Order {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DERDASH\\Desktop\\DUO TECH\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
// 1. Open Chrome browser
        System.out.println("***** Step 1. Open Chrome browser");

// 2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        System.out.println("***** Step 2. Navigate to Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

// 3.a Login using username Tester and password test
        System.out.println("***** Step 3.a Login using username Tester ");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");

// 3.b Login using username Tester and password test
        System.out.println("***** Step 3.b Login using password test and enter ");
        // driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        // driver.findElement(By.className("button")).click();
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER );

// 4. Click on Order link
        System.out.println("***** Step 4. Click on Order link");
       //  String xpath = "/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a";
       //  String text = driver.findElement(By.xpath(xpath)).getText();
       //  driver.findElement(By.partialLinkText(text)).click();
        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

// 5. Enter a random quantity between 1 and 100
        System.out.println("***** Step 5. Enter a random quantity between 1 and 100");
        int r = (int) (Math.random() * 100);
        String random1_100 = "" + r;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(random1_100);
        System.out.println(r);           // just printing out for fun

// 6. Enter Customer Name as  random String of uppercase and lowercase letters with length 5 for First and Last name:
       //  For example sdTFs Hsfsa
        System.out.println("***** Step 6. Enter Customer Name as  random String of uppercase and lowercase letters with length 5 for First and Last name:");
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

// 7. Enter street: 8607 Westwood Center Dr
        System.out.println("***** Step 7. Enter street: 8607 Westwood Center Dr");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("8607 Westwood Center Dr");
        Thread.sleep(1000);

// 8. Enter City: Vienna
        System.out.println("***** Step 8. Enter City: Vienna");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Vienna");

// 9. Enter State: Virginia
        System.out.println("***** Step 9. Enter State: Virginia");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");

// 10. Enter a random 5 digit number to the zip code field
        System.out.println("***** Step 10. Enter a random 5 digit number to the zip code field");
        int y = (int)(10000+ (Math.random() * 90_000));String random5 = "" + y;
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(random5);
        System.out.println(y); // just printing out for fu


// 11. Select any card type. Every time your code should select a different type.
        System.out.println("***** Step 11. Select any card type. Every time your code should select a different type.");
       int cT = (int)(Math.random()*3);
       // Version a with id
       // Version b with CssSelector
       // 2nd Version of Step 11  (line 104-111) getting list of webElements, clicking by index.
//        if  (cT==0){
//        a. //    driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
//        b. //    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).click();
//        }else if (cT==1) {
//         a. //   driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
//         b. //   driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1")).click();
//        }else {
//         a. //   driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
//         b. //   driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_2")).click();
//        }
        System.out.println(cT); // just printing out for fu
        Thread.sleep(1000);
       // Step 11 version II

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        if  (cT==0){
            radioButtons.get(0).click();
        }else if (cT==1) {
            radioButtons.get(1).click();
        }else{
            radioButtons.get(2).click();
        }

        Thread.sleep(1000);
// 12. Enter a card number:
        System.out.println("***** Step 12. Enter a card number:");
        int singleRandom = (int) (Math.random() * 10);
        int cfh = (int) (1000000 + (Math.random() * 9000000)); // Random 7 digits int num will first part
        int csh = (int) (1000000 + (Math.random() * 9000000)); // another 7 digits int num will second part
        String fr = "" + cfh + csh;                            // 14 digits concatenate as String (hint a -1 )

        String visaCARD   = "4" + fr + singleRandom; // If you selected Visa,             card number should start with 4.
        String masterCARD = "5" + fr + singleRandom; // If you selected Master,           card number should start with 5.
        String amexCARD   = "3" + fr ;               // If you selected American Express, card number should start with 3.

         //  New card number should be auto generated every time you run the test.
         //   Card numbers should be 16 digits for Visa and Master, 15 for American Express.

        if  (cT==0){
                    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(visaCARD);
        }else if (cT==1) {
                    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(masterCARD);
        }else {
                    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(amexCARD);
        }
        System.out.println((cT==0) ? "Visa " + visaCARD : (cT==1) ? "Master " +masterCARD : "Amex " + amexCARD);

// 13. Enter a valid expiration date (newer than the current date)
        System.out.println("***** Step 13. Enter a valid expiration date (newer than the current date)");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
        LocalDateTime now = LocalDateTime.now().plusMonths(1) ;
        String dateNew = dtf.format(now);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(dateNew);
        System.out.println(dateNew);

// 14. Click on Process
        System.out.println("***** Step 14. Click on Process");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        System.out.println("Click Process");

// 15. Verify that the page contains text “New order has been successfully added”.
        System.out.println("***** Step 15. Verify that the page contains text “New order has been successfully added”.");
        String verifytext = "New order has been successfully added.";
        Thread.sleep(1000);
        System.out.println  (driver.getPageSource().contains(verifytext)? "Pass, page contains \"" + verifytext + "\"": "Fail, does not page contains \"" + verifytext + "\"");

// Push your project to GitHub and submit your GitHub repository link

    }}



