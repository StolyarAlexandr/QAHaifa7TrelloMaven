package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(By locator, int time) {
        try {
            new WebDriverWait (driver,time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsAreVisible(List<WebElement> elementsList, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElements(elementsList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }


}
