package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CourseTile {

    private final WebElement rootElement;

    public CourseTile(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    public String getCourseName() {
        return rootElement.findElement(By.cssSelector(".course-card__title")).getText();
    }

    public void click() {
        rootElement.click();
    }
}