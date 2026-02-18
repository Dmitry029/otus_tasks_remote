package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage {

    private final WebDriver driver;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCourseTitle() {
        return driver.findElement(By.cssSelector(".course-header__title")).getText();
    }
}