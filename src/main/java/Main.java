  import org.openqa.selenium.By;
  import org.openqa.selenium.JavascriptExecutor;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.support.ui.Select;
  import java.util.List;
  import static java.lang.System.setProperty;

  public class Main {

    public static void main(String[] args) throws InterruptedException {


      setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
      driver.get("https://www.avito.ru/");
      //out.println(driver.getPageSource());

      Select categorySelector = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
      categorySelector.selectByVisibleText("Оргтехника и расходники");

      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='main-select-2pf7p main-location-3j9by']")).click();
      driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток");
      Thread.sleep(8000);
      driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
      driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
      driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']")).getAttribute("value");
      String V = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']")).getAttribute("class");
      System.out.println(V);
      Thread.sleep(2000);

      if (!(V.contains("checked"))) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));

        js.executeScript("arguments[0].click();", element);

        System.out.println("чекбокс активирован");
      } else {
        System.out.println("чекбокс уже активирован");
      }

      driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
      Thread.sleep(2000);
      //driver.findElement(By.xpath("//div[@class='form-select-v2 sort-select-3QxXG']/select")).click();
      driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).click();
      Thread.sleep(4000);
      //driver.findElement(By.xpath("//div[@class='form-select-v2 sort-select-3QxXG']/select/option[3]")).click();
      driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select/option[3]")).click();

      Select categorySelector_2 = new Select(driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")));
      categorySelector_2.selectByVisibleText("Дороже");


//Далее в теории должны быть такие варианты, но у меня в браузере они не работают
//div[@id='i2008889556']/descendant::span[text()=’name’]
//div[@id='i2008889556']/descendant::span[text()=’item-price’]

      List<WebElement> items = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
      for (int i = 0; i < 3; i++) {

        System.out.println(items.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
        System.out.println(items.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price ']")).getText());

//System.out.println(driver.findElement(By.xpath("//div[@id='i2008889556']/descendant::span[text()=’name’]")).getText());
//System.out.println(driver.findElement(By.xpath("//div[@id='i2008889556']/descendant::span[text()=’item-price’]")).getText());


//div[@id='i2020561662']
//div[@id='i1946935781']
//div[@id='i2008889556']


      }

    }

  }
