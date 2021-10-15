import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class Main {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://megogo.net/ru");
        WebElement searchBtn = driver.findElement((By.className("svgicon-search-quick")));
        searchBtn.click();
    }

    @Test
    public void task1() {
        driver.findElement(By.name("q")).sendKeys("Gifted", Keys.RETURN);
        WebElement film = driver.findElement(By.cssSelector("a[title='Одарённая']"));
        Assert.assertTrue(film.isDisplayed());
    }

    @Test
    public void task2() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Gifted", Keys.RETURN);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("img[alt='Одарённая']")).click();
        WebElement filmTitle = driver.findElement(By.xpath("//*[@id=\"widget_14\"]/div/div[2]/div[2]/div/div[1]/h1"));
        Assert.assertTrue(filmTitle.isDisplayed());
    }

    @Test
    public void task3() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Gifted");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[title='Одарённая']")).click();
        Thread.sleep(3000);
        WebElement filmTitle = driver.findElement(By.xpath("//*[@id=\"widget_14\"]/div/div[2]/div[2]/div/div[1]/h1"));
        Assert.assertTrue(filmTitle.isDisplayed());
    }

    @Test
    public void task4() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Gifted");
        Thread.sleep(2000);
        driver.findElement(By.className("svgicon-search-close")).click();
        WebElement filtersLink = driver.findElement(By.className("js-filters"));
        Assert.assertTrue(filtersLink.isDisplayed());
    }

    @After
    public void close() {
        driver.close();
    }
}
