import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Year;
import java.util.Random;

public class GmailGenerator {
    public static void main(String[] args) throws Exception {

        // Initialise
        System.setProperty("webdriver.chrome.driver", "J:\\Users\\Justin\\Documents\\Selenium\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("J:\\Users\\Justin\\Documents\\Selenium\\chrome-win64\\chrome.exe");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);

        // DD/MM/YYYY & Gender Generator
        Random random = new Random();
        // YEAR
        Year currentYear = Year.now();
        int sysYear = currentYear.getValue();
        int year = random.nextInt(1950, sysYear - 18);
        // MONTH
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String month = months[random.nextInt(0, months.length)];
        // DAY
        int day = 0;
        switch (month) {
            case "February" -> day = random.nextInt(0, 28) + 1;
            case "January", "March", "May", "July", "August", "October", "December" -> day = random.nextInt(0, 31) + 1;
            case "April", "June", "September", "November" -> day = random.nextInt(0, 30) + 1;
            default -> day = 1;
        }
        // GENDER
        int randomGenderGenerator = random.nextInt(0,2);
        String gender;
        switch (randomGenderGenerator) {
            case 0 -> gender = "Male";
            case 1 -> gender = "Female";
            default -> gender = "Prefer not to say";
        }

        // Setting First & Last Names from NameGenerator
        NameGenerator nameGenerator = new NameGenerator();

        String name = nameGenerator.Generate();

        String firstName = name.substring(0, name.indexOf(' '));
        String lastName = name.substring(name.indexOf(' '));

        // Start Gmail Registering Process
        driver.get("https://www.gmail.com");

        // Click Register button and select "personal use" from li element
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d LQeN7 FliLIb uRo0Xe TrZEUc Xf9GD']")).click();
        driver.findElement(By.xpath("//li[@class='G3hhxb VfPpkd-StrnGf-rymPhb-ibnC6b']")).click();

        // First name & Last name
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();
        Thread.sleep(5000);

        // DD/MM/YYYY & Gender
        driver.findElement(By.id("day")).sendKeys(Integer.toString(day));
        driver.findElement(By.id("year")).sendKeys(Integer.toString(year));
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("gender")).sendKeys(gender);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();

        // Select email address without @gmail.com
        Thread.sleep(10000);
        driver.findElement(By.name("Username")).sendKeys("67868YGUYGHJUG.lastname");
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();

        // Password & Confirm Password
        Thread.sleep(5000);
        driver.findElement(By.name("Passwd")).sendKeys("12346678");
        driver.findElement(By.name("PasswdAgain")).sendKeys("12346678");

        Thread.sleep(5000);

    }
}
