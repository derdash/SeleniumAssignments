package SeleniumAssignments;

import static java.lang.Thread.sleep;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class SeleniumAssignment02_Automation_Project_02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DERDASH\\Desktop\\DUO TECH\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//1. Go to carfax.com
        driver.get("https://www.carfax.com/");
        System.out.println("-_-_-_-_-_-_ Step 1     Go to carfax.com_-_-_-_-_-_-");

//2. Click on Find a Used Car
        driver.findElement(By.xpath("//a[@class='button button--green']")).click();
        System.out.println("-_-_-_-_-_-_ Step 2     Click on Find a Used Car _-_-_-_-_-_-");

//3. Verify the page title contains the word “Used Cars”
        System.out.println( driver.getTitle().contains("Used Cars") ? "PASS, The page title contains the word \"Used Cars\"" : "FAIL");
        System.out.println("-_-_-_-_-_-_ Step 3     Verify the page title contains the word \"Used Cars\" _-_-_-_-_-_-");

//4. Choose “Tesla” for  Make.
//        driver.findElement(By.name("make")).sendKeys("Tesla" +Keys.ENTER+Keys.TAB);
//        sleep(1000);
//        driver.findElement(By.name("make")).sendKeys("Tesla" +Keys.ENTER+Keys.TAB);
//        System.out.println("-_-_-_-_-_-_ Step 4     Choose \"Tesla\" for  Make _-_-_-_-_-_-");

        WebElement makeType = driver.findElement(By.name("make"));Thread.sleep(1000);
        Select select = new Select(makeType);

    select.selectByValue("Tesla");Thread.sleep(1000);

//5. Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X).

//5.a Choosing "Select Model"
        driver.findElement(By.name("model")).sendKeys("Select Model" +Keys.ENTER);
//5.b Getting text Verify
        String currentTeslaModels = driver.findElement(By.xpath("//*[@id=\"makeModelPanel\"]/form/div[2]/div/select/optgroup[1]")).getText();

        String model3 = driver.findElement(By.xpath("//option[@id= 'model_Model-3']")).getText();
        String modelS = driver.findElement(By.xpath("//option[@id= 'model_Model-S']")).getText();
        String modelX = driver.findElement(By.xpath("//option[@id='model_Model-X']")).getText();

        System.out.println("Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X).");
        if (currentTeslaModels.contains(model3)){
            System.out.println("Pass, dropdown box contains " + model3);
        }if (currentTeslaModels.contains(modelS)) {
            System.out.println("Pass, dropdown box contains " + modelS);
        }if (currentTeslaModels.contains(modelX)) {
            System.out.println("Pass, dropdown box contains " + modelX);
        }
        System.out.println("-_-_-_-_-_-_ Step 5     Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X) _-_-_-_-_-_-");

//6. Choose “Model S” for Model.
        driver.findElement(By.xpath("//option[@id= 'model_Model-S']")).click();

        System.out.println("-_-_-_-_-_-_ Step 6     Choose \"Model S\" for Model _-_-_-_-_-_-");

//7. Enter the zipcode as 22182 and click Next
        driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("22182"+ Keys.ENTER);
        System.out.println("-_-_-_-_-_-_ Step 7     Enter the zipcode as 22182 and click Next _-_-_-_-_-_-");

//8. Verify that the page has “Step 2 – Show me cars with” text
        System.out.println(   driver.getPageSource().contains("Step 2 - Show me cars with")?"Pass, he page has \"Step 2 – Show me cars with\" text" :""  );
        System.out.println("-_-_-_-_-_-_ Step 8     Verify that the page has \"Step 2 – Show me cars with\" text _-_-_-_-_-_-");

//9. Click on all 4 checkboxes.
        driver.findElement(By.xpath("//div[@class= 'noAccident']")).click();
        driver.findElement(By.xpath("//div[@class= 'owner1']")).click();
        driver.findElement(By.xpath("//div[@class= 'personal']")).click();
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[4]/label/span[2]")).click();
        System.out.println("-_-_-_-_-_-_ Step 9     Click on all 4 checkboxes_-_-_-_-_-_-");
//10. Save the result of “Show me X Results” button to a variable. In this case it is 6.
        int result =  Integer.parseInt( driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText() ) ;
        System.out.println("Total result is: " + result);
        System.out.println("-_-_-_-_-_-_ Step 10     Save the result of \"Show me X Results\" button to a variable. In this case it is 6 _-_-_-_-_-_-");

//11. Click on “Show me x Results” button.
        driver.findElement(By.xpath("//button[@class='button large primary-green show-me-search-submit']")).click();
        System.out.println("-_-_-_-_-_-_ Step 11     Click on \"Show me x Results\" button._-_-_-_-_-_-");

//12. On the next page, verify that the results page has the same number of results as indicated in Step 10 by extracting the number and comparing the result
        int resultConfirm = Integer.parseInt(  driver.findElement(By.xpath("//span[@id='totalResultCount']")).getText());
        System.out.println((resultConfirm==result)?"Pass, results page has the same number of results as indicated in Step 10": "Fail" + resultConfirm);
        System.out.println("-_-_-_-_-_-_ Step 12     On the next page, verify that the results page has the same number of results as indicated in Step 10 by extracting the number and comparing the result _-_-_-_-_-_-");

//13. Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10. For this step get the count the number of WebElements related to each result.
        List<WebElement> elements  = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        int c13=0;
        for (WebElement el13: elements) {
            c13++ ;
        }
        System.out.println((result==c13)?"Pass, Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10":"Fail");
        System.out.println("-_-_-_-_-_-_ Step 13     Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10. For this step get the count the number of WebElements related to each result._-_-_-_-_-_-");

//14. Verify that each result contains String “Tesla Model S”.
        int c14=0;
        String cR = "Tesla Model S";
        List<WebElement> elements14  = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement el14: elements14) {
            c14++;
            System.out.println(el14.getText().contains(cR)?"Pass, contains "+ cR +" "+ c14 +" times":"Fail");
        }
        System.out.println("-_-_-_-_-_-_  Step 14 Verify that each result contains String \"Tesla Model S\"_-_-_-_-_-_-");

//15. Get the price of each result and save them into a list in the order of their appearance.
        List<String> actualList15 = new ArrayList<>();
        List<WebElement> elements15  = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));
        for (WebElement el15: elements15) {
            actualList15.add(el15.getText().substring(7));
        }
        System.out.println(actualList15);
        System.out.println("-_-_-_-_-_-_  Step 15    Get the price of each result and save them into a list in the order of their appearance _-_-_-_-_-_-");

//16. Choose “Price - High to Low” option from Sort menu
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Price"+ Keys.ENTER+ Keys.TAB);
        System.out.println("-_-_-_-_-_-_  Step 16    Choose \"Price - High to Low\" option from Sort menu_-_-_-_-_-_-");

//17. Verify that the results are displayed from high to low price.
        Thread.sleep(1000);
        List<String> actualList17 = new ArrayList<>();
        List<WebElement> elements17  = driver.findElements(By.xpath("//article//div//div//span[@class='srp-list-item-price']"));

        for (WebElement el17: elements17) {
            actualList17.add(el17.getText().substring(7));
        }
        System.out.println(actualList17);
        System.out.println("------- Step 17     Verify that the results are displayed from high to low price-------");

//18  Choose “Mileage - Low to High” option from Sort menu
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("m"+ Keys.ENTER+ Keys.TAB);
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("m"+ Keys.ENTER+ Keys.TAB);
        System.out.println("------- Step 18     Choose \"Mileage - Low to High\" option from Sort menu-------");


//19. Verify that the results are displayed from low to high mileage.
        Thread.sleep(1000);
        List<String> actualList19 = new ArrayList<>();

        List<WebElement> elements19 = driver.findElements(By.xpath("//div[@class='srp-list-item-basic-info srp-list-item-special-features']"));

        for (WebElement e19: elements19) {
            actualList19.add( e19.getText().substring(9,  (e19.getText().indexOf('m')))     );
        }
        System.out.println(actualList19);
        System.out.println("------- Step 19    Verify that the results are displayed from low to high mileage-------");


//20. Choose “Year - New to Old” option from Sort menu
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Y"+ Keys.ENTER + Keys.TAB);
        System.out.println("------- Step 20     Choose \"Year - New to Old\" option from Sort menu-------");

//21. Verify that the results are displayed from new to old year.
        Thread.sleep(1000);
        List<String> actualList21 = new ArrayList<>();
        List<WebElement> elements21 = driver.findElements(By.xpath("//article//div//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement e21: elements21) {
            System.out.println(e21.getText());
        }



        System.out.println("------- Step 21     Verify that the results are displayed from new to old year-------");
    }   }


