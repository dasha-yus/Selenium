const { Builder, By, Key } = require("selenium-webdriver");

let driver = new Builder().forBrowser("firefox").build();

async function common() {
  const searchBtn = driver.findElement(By.className("svgicon-search-quick"));
  await driver.get("https://megogo.net/ru");
  await searchBtn.click();
}

async function task1() {
  await common();
  await driver.findElement(By.name("q")).sendKeys("Gifted", Key.RETURN);
}

async function task2() {
  await common();
  await driver.findElement(By.name("q")).sendKeys("Gifted", Key.RETURN);
  await driver.sleep(5000);
  await driver
    .findElement(
      By.xpath(
        "/html/body/div[2]/div[4]/main/div/div[2]/div/div/div[3]/div[1]/section/div/div[2]/div[2]/div/div/div[1]/div[1]"
      )
    )
    .click();
}

async function task3() {
  await common();
  await driver.findElement(By.name("q")).sendKeys("Gifted");
  await driver.sleep(2000);
  await driver
    .findElement(
      By.xpath("//div[@id='widget_16']/div/div[2]/div/div[1]/div/div[1]")
    )
    .click();
}

async function task4() {
  await common();
  await driver.findElement(By.name("q")).sendKeys("Gifted");
  await driver.sleep(2000);
  await driver
    .findElement(By.className("svgicon svgicon-search-close"))
    .click();
}

task1();
// task2();
// task3();
// task4();
