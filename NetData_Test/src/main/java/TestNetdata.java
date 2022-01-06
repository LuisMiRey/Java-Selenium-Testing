import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static javax.swing.JOptionPane.showMessageDialog;


public class TestNetdata {

    WebDriver driver;
    @Before
    public void setUp(){
        //Telling the system where to find chromedriver. On Windows you also need to add .exe Need to be the same as you Chrome.
        //If you are using linux please download chrome driver for linux here --- https://chromedriver.chromium.org/
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,60);
        //Navigate to the URL. Change it if necessary
        driver.get("http://localhost:19999/");
        driver.manage().window().maximize();
        ExecuteStress nuevo = new ExecuteStress();
        nuevo.newTest();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div.flex-sc-1m6gk2e-0.layout__Wrapper-sc-1d05imu-0.cHSTTW.bQbmqw > header > div.flex-sc-1m6gk2e-0.hUxsPM > div.flex-sc-1m6gk2e-0.cmoUrQ > div.flex-sc-1m6gk2e-0.styled__StyledPill-sc-1rgk900-0.haExPb.idLlCh")));
        driver.findElement(By.cssSelector("#root > div.flex-sc-1m6gk2e-0.layout__Wrapper-sc-1d05imu-0.cHSTTW.bQbmqw > header > div.flex-sc-1m6gk2e-0.hUxsPM > div.flex-sc-1m6gk2e-0.cmoUrQ > div.flex-sc-1m6gk2e-0.styled__StyledPill-sc-1rgk900-0.haExPb.idLlCh")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"text-center\"]/b[text()=\"disk_backlog.sdd\"]")));
        WebElement alarmElement = driver.findElement(By.xpath("//*[@class=\"text-center\"]/b[text()=\"disk_backlog.sdd\"]"));
        Assert.assertEquals("disk_backlog.sdd",alarmElement.getText());
        System.out.println("Alarm found");
        System.out.println("Time necessary");

        Thread.sleep(700000);  //Time required to values to return to normal 10 minutes.

        System.out.println(("Time is up"));
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div.flex-sc-1m6gk2e-0.layout__Wrapper-sc-1d05imu-0.cHSTTW.bQbmqw > header > div.flex-sc-1m6gk2e-0.hUxsPM > div.flex-sc-1m6gk2e-0.cmoUrQ > div.flex-sc-1m6gk2e-0.styled__StyledPill-sc-1rgk900-0.haExPb.idLlCh")));
        driver.findElement(By.cssSelector("#root > div.flex-sc-1m6gk2e-0.layout__Wrapper-sc-1d05imu-0.cHSTTW.bQbmqw > header > div.flex-sc-1m6gk2e-0.hUxsPM > div.flex-sc-1m6gk2e-0.cmoUrQ > div.flex-sc-1m6gk2e-0.styled__StyledPill-sc-1rgk900-0.haExPb.idLlCh")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alarmsModalLabel\"]")));
        boolean alarmExists = driver.findElements(By.xpath("//*[@class=\"text-center\"]/b[text()=\"disk_backlog.sdd\"]")).isEmpty();

        if(alarmExists){
            System.out.println("Successful Test Netdata");
            showMessageDialog(null, "Successful Test Netdata");
        }else{
            System.out.println("Alarm is still there :(");
            showMessageDialog(null,"Alarm is still there :(");
        }


    }

}
