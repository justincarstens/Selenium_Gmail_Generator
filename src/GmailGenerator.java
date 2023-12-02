import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class GmailGenerator {

    private static final Logger LOGGER = Logger.getLogger(GmailGenerator.class.getName());
    public static void main(String[] args) throws Exception {

        // Initialise ChromeDriver & Chrome for Testing session
        System.setProperty("webdriver.chrome.driver", getChromeDriver());
        ChromeOptions options = new ChromeOptions();
        options.setBinary(getChromeExe());
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);

        // Generate DD/MM/YYYY & Gender from PersonalInfo class
        PersonalInfo personalInfo = new PersonalInfo();
        int day = personalInfo.getDay();
        String month = personalInfo.getMonth();
        int year = personalInfo.getYear();
        String gender = personalInfo.getGender();

        // Setting First & Last Names from NameGenerator
        NameGenerator nameGenerator = new NameGenerator();
        String name = nameGenerator.Generate();
        String firstName = name.substring(0, name.indexOf(' '));
        String lastName = name.substring(name.indexOf(' ') + 1);

        // Generate 'username' (email address)
        String username = firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + Integer.toString(year).substring(2);

        // Generate password from PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.Generate();

        // Start Gmail Registering Process
        driver.get("https://www.gmail.com");

        // Click Register button and select "personal use" from li element
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d LQeN7 FliLIb uRo0Xe TrZEUc Xf9GD']")).click();
        driver.findElement(By.xpath("//li[@class='G3hhxb VfPpkd-StrnGf-rymPhb-ibnC6b']")).click();

        // Input first name & last name
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();
        Thread.sleep(5000);

        // DD/MM/YYYY & Gender fields
        driver.findElement(By.id("day")).sendKeys(Integer.toString(day));
        driver.findElement(By.id("year")).sendKeys(Integer.toString(year));
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("gender")).sendKeys(gender);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();

        // Select custom email address option & input 'username'
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='zJKIV y5MMGc sD2Hod' and @role='radio' and @aria-labelledby='selectioni3']")).click();
        driver.findElement(By.name("Username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();

        // Password & Confirm Password
        Thread.sleep(3000);
        driver.findElement(By.name("Passwd")).sendKeys(password);
        driver.findElement(By.name("PasswdAgain")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();
        Thread.sleep(2000);

        driver.close();

    }

    public static String getChromeDriver() {
        //Reading API Key from config.properties file to ensure API Key stays private
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.severe("Error reading configuration: " + e.getMessage());
        }
        return properties.getProperty("chromedriver");
    }

    public static String getChromeExe() {
        //Reading API Key from config.properties file to ensure API Key stays private
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.severe("Error reading configuration: " + e.getMessage());
        }
        return properties.getProperty("chrome.exe");
    }
}
