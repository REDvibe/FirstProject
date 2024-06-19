import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class NextTest {

    @Test
    public void Nextsteps() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implcitly wait for each the whole program
        driver.get("https://www.next.co.uk/");
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        System.out.println(driver.getTitle());
        String actualTitle = "Next Official Site: Online Fashion, Kids Clothes & Homeware";
        String expectedTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
        System.out.println("The END");
        System.out.println(driver.getCurrentUrl());
        String actualURL = "https://www.next.co.uk/";
        String expectedURL = driver.getCurrentUrl();
        if(actualURL.equals(expectedURL)){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }

        boolean idDisplayed = driver.findElement(By.xpath("//div[@class='header-16xf38x']//img[@alt='Go to the homepage for clothes & more']")).isDisplayed();
        if(idDisplayed==true){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
        Thread.sleep(3000);

        boolean isEnabledSignIn = driver.findElement(By.xpath("//a[@data-testid='header-adaptive-my-account-icon-container-link']//img[@alt='Sign in to view account details']")).isEnabled();
        boolean isEnabledCheckout = driver.findElement(By.xpath("//a[text() = 'Checkout']")).isEnabled();

        if (isEnabledSignIn==true){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }

        if (isEnabledCheckout==true){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
        WebElement button = driver.findElement(By.xpath("//a[@aria-disabled= 'true']"));
        String classAttribute = button.getAttribute("aria-disabled");
        boolean isEnabled2 = button.isEnabled();
        boolean isDisabledByClass = classAttribute != null && classAttribute.contains("true");

        //Final determination of the button's enabled state
        boolean finalEnabledState = isEnabled2 && !isDisabledByClass;

        // Output the result
        System.out.println("Is the button enabled? " + finalEnabledState);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[2]/div[2]/div/a")).click();
        boolean LoginDisplayed = driver.findElement(By.xpath("//*[@id=\"pri\"]/div/div/h2")).isDisplayed();
        if (LoginDisplayed==true){
            System.out.println("Working");
        }
        else {
            System.out.println("Not Working");
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"passwordLogin\"]/div[3]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"dialogWindowContent\"]/a")).click();

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id ='header-big-screen-search-box']")).sendKeys("Bags");
        driver.findElement(By.xpath("//button[@type ='submit']")).click();

        WebDriverWait drv = new WebDriverWait(driver,Duration.ofSeconds(5));
        drv.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='plp-idx6q4']")));

        driver.findElement(By.xpath("//input[@tabindex='-1' and @type='checkbox']")).click();

        drv.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='produc-ivbv8a']")));

        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath("//h2[@class='produc-ivbv8a']"));

        for(int i= 0; i< 5; i++){
            System.out.println(list.get(i).getText());
        }

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[text()='women']"))).perform();
        drv.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='The Linen Shop']"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("")).click();

// //ul/li[starts-with(@class,'sbct')] - autosugesttion lists.
        //Alert alert = driver.switchTo().alert();
        //System.out.println(alert.getText());
        driver.close();



    }

}
