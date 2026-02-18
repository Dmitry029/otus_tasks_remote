package org.example.listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.WrapsDriver;

public class HighlightingListener implements WebDriverListener {

    private void highlight(WebElement element) {
        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
        String script = "arguments[0].style.border='3px solid red'";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    @Override
    public void beforeClick(WebElement element) {
        highlight(element);
    }

}