package Automation_Project_02_CarFax_Used_Car_Search;

import static java.lang.Thread.sleep;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignment02_Automation_Project_02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DERDASH\\Desktop\\DUO TECH\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//1. Go to carfax.com
        System.out.println("***** Step 1     Go to carfax.com");
        driver.get("https://www.carfax.com/");

//2. Click on Find a Used Car
        System.out.println("***** Step 2     Click on Find a Used Car");
        driver.findElement(By.xpath("//a[@class='button button--green']")).click();

//3. Verify the page title contains the word “Used Cars”
        System.out.println("***** Step 3     Verify the page title contains the word \"Used Cars\"");
        System.out.println( driver.getTitle().contains(  "Used Cars") ? "\t\t\t\tPASS, The page title contains the word \"Used Cars\"" : "\t\t\t\tFAIL");

//4. Choose “Tesla” for  Make.
        System.out.println("***** Step 4     Choose \"Tesla\" for  Make");
        // driver.findElement(By.name("make")).sendKeys("Tesla" +Keys.ENTER+Keys.TAB);
        // sleep(1000);
        // driver.findElement(By.name("make")).sendKeys("Tesla" +Keys.ENTER+Keys.TAB);

        WebElement makeType = driver.findElement(By.name("make"));
        Thread.sleep(1000);
        Select select = new Select(makeType);
        select.selectByValue("Tesla");
        Thread.sleep(1000);

//5. Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S , Model X).
        System.out.println("***** Step 5     Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X)");
//5.a Choosing "Select Model"
        driver.findElement(By.name("model")).sendKeys("Select Model" +Keys.ENTER);
//5.b Getting text Verify
        String currentTeslaModels = driver.findElement(By.xpath("//*[@id=\"makeModelPanel\"]/form/div[2]/div/select/optgroup[1]")).getText();

        String model3 = "Model 3";
        String modelS = "Model S";
        String modelX = "Model X";

        System.out.println("\t\t\t\tVerify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X).");
        if (currentTeslaModels.contains(model3)){
            System.out.println("\t\t\t\tPass, dropdown box contains " + model3);
        }if (currentTeslaModels.contains(modelS)) {
            System.out.println("\t\t\t\tPass, dropdown box contains " + modelS);
        }if (currentTeslaModels.contains(modelX)) {
            System.out.println("\t\t\t\tPass, dropdown box contains " + modelX);
        }


//6. Choose “Model S” for Model.
        System.out.println("***** Step 6     Choose \"Model S\" for Model");
        driver.findElement(By.xpath("//option[@id= 'model_Model-S']")).click();

//7. Enter the zipcode as 22182 and click Next
        System.out.println("***** Step 7     Enter the zipcode as 22182 and click Next");
        driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("22182"+ Keys.ENTER);

//8. Verify that the page has “Step 2 – Show me cars with” text
        System.out.println("***** Step 8     Verify that the page has \"Step 2 – Show me cars with\" text");
        System.out.println(   driver.getPageSource().contains("Step 2 - Show me cars with")?"\t\t\t\tPass, he page has \"Step 2 – Show me cars with\" text" :"\t\t\t\tFail"  );

//9. Click on all 4 checkboxes.
        System.out.println("***** Step 9     Click on all 4 checkboxes");
        //  driver.findElement(By.xpath("//div[@class= 'noAccident']")).click();
        //  driver.findElement(By.xpath("//div[@class= 'owner1']")).click();
        //  driver.findElement(By.xpath("//div[@class= 'personal']")).click();
        //  driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[4]/label/span[2]")).click();
        //   Version 2nd      base on --April 14 class -Radio button and Check box
        List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@role='checkbox']"));
        for (WebElement e: checkboxes) {
            if(!e.isSelected())
                e.click();
        }

//10. Save the result of “Show me X Results” button to a variable. In this case it is 6.
        System.out.println("***** Step 10     Save the result of \"Show me X Results\" button to a variable. In this case it is 6");
        int result =  Integer.parseInt( driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText() ) ;
        System.out.println("\t\t\t\tTotal result is: " + result);

//11. Click on “Show me x Results” button.
        System.out.println("***** Step 11     Click on \"Show me x Results\" button.");
        driver.findElement(By.xpath("//button[@class='button large primary-green show-me-search-submit']")).click();

//12. On the next page, verify that the results page has the same number of results as indicated in Step 10 by extracting the number and comparing the result
        System.out.println("***** Step 12     On the next page, verify that the results page has the same number of results as indicated in Step 10 by extracting the number and comparing the result");
        int resultConfirm = Integer.parseInt(  driver.findElement(By.xpath("//span[@id='totalResultCount']")).getText());
        System.out.println((resultConfirm==result)?"\t\t\t\tPass, results page has the same number of results as indicated in Step 10": "\t\t\t\tFail" + resultConfirm);

//13. Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10. For this step get the count the number of WebElements related to each result.
        System.out.println("***** Step 13     Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10. For this step get the count the number of WebElements related to each result");
        List<WebElement> elements  = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        int c13=0;
        for (WebElement el13: elements) {
            c13++ ;
        }
        System.out.println((result==c13)?"\t\t\t\tPass, Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10":"\t\t\t\tFail");

//14. Verify that each result contains String “Tesla Model S”.
        System.out.println("***** Step 14     Verify that each result contains String \"Tesla Model S\"");
        int c14=0;
        String cR = "Tesla Model S";
        List<WebElement> elements14  = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement el14: elements14) {
            c14++;
            System.out.println(el14.getText().contains(cR)?"\t\t\t\tPass, contains "+ cR +" "+ c14 +" times":"\t\t\t\tFail");
        }


//15. Get the price of each result and save them into a list in the order of their appearance.
        System.out.println("***** Step 15     Get the price of each result and save them into a list in the order of their appearance");
        List<String> actualList15 = new ArrayList<>();
        List<WebElement> elements15  = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));
        for (WebElement el15: elements15) {
            actualList15.add(el15.getText().substring(7));
        }
        System.out.print("\t\t\t\t");System.out.println(actualList15);

//16. Choose “Price - High to Low” option from Sort menu
        System.out.println("***** Step 16     Choose \"Price - High to Low\" option from Sort menu");
       // driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Price"+ Keys.ENTER+ Keys.TAB);
        WebElement sortBY  = driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']"));Thread.sleep(1000);
        Select selectSortBY = new Select(sortBY);
        selectSortBY.selectByValue("PRICE_DESC");Thread.sleep(2000);

//17. Verify that the results are displayed from high to low price.
        System.out.println("***** Step 17     Verify that the results are displayed from high to low price");
        Thread.sleep(1000);
        List<String> actualList17 = new ArrayList<>();
        List<WebElement> elements17  = driver.findElements(By.xpath("//article//div//div//span[@class='srp-list-item-price']"));

        for (WebElement el17: elements17) {
            actualList17.add(el17.getText().substring(7));
        }
        System.out.print("\t\t\t\t"); System.out.println(actualList17);


//18  Choose “Mileage - Low to High” option from Sort menu
        System.out.println("***** Step 18     Choose \"Mileage - Low to High\" option from Sort menu");
        //driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("m"+ Keys.ENTER+ Keys.TAB);
       // driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("m"+ Keys.ENTER+ Keys.TAB);
        selectSortBY.selectByValue("MILEAGE_ASC");

//19. Verify that the results are displayed from low to high mileage.
        System.out.println("***** Step 19     Verify that the results are displayed from low to high mileage");
        Thread.sleep(1000);
        List<String> actualList19 = new ArrayList<>();
        List<WebElement> elements19 = driver.findElements(By.xpath("//div[@class='srp-list-item-basic-info srp-list-item-special-features']"));
        for (WebElement e19: elements19) {
            actualList19.add( e19.getText().substring(9,  (e19.getText().indexOf('m')))     );
        }
        System.out.print("\t\t\t\t");  System.out.println(actualList19);


//20. Choose “Year - New to Old” option from Sort menu
        System.out.println("***** Step 20     Choose \"Year - New to Old\" option from Sort menu");
        Thread.sleep(1000);
        selectSortBY.selectByValue("YEAR_DESC");

//21. Verify that the results are displayed from new to old year.
        System.out.println("***** Step 21     Verify that the results are displayed from new to old year");
        Thread.sleep(1000);
        List<String> actualList21 = new ArrayList<>();
        List<WebElement> elements21 = driver.findElements(By.xpath("//article//div//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement e21: elements21) {
            System.out.print("\t\t\t\t");System.out.println(e21.getText());
        }    }   }


