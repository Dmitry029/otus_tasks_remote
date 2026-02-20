package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends AbsBasePage {

    @FindBy(css = "h1")
    private WebElement courseTitle;

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public String getCourseTitle() {
        return courseTitle.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}