package com.slapkirk;

import drivers.ChromeWebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class slaps {

  WebDriver webDriver = new ChromeWebDriver().getWebDriver();

  WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);

  @Test
  public void slapsPerSecondAverage() {
    webDriver.navigate().to("http://www.slapkirk.com/play");
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("animationImage")));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
    javascriptExecutor.executeScript("e = $.Event('mousemove');");
    javascriptExecutor.executeScript("e.pageX = 2000;");
    javascriptExecutor.executeScript("w = $.Event('mousemove');");
    javascriptExecutor.executeScript("w.pageX = 100;");

    for (int i = 0; i < 1000; i++) {
      javascriptExecutor.executeScript("$(document).trigger(e);");
      javascriptExecutor.executeScript("$(document).trigger(w);");
    }

    String slappies = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("highScoreBox")))
            .getText();

    System.out.println(slappies);
  }
}
