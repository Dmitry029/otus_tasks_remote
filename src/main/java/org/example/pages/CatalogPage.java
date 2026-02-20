package org.example.pages;

import org.example.exceptions.CourseNotFoundException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbsBasePage {

    private final String url;

    @FindBy(css = "main section a[class*='sc-zz']")
    private List<WebElement> courseCards;


    // Принимаем уже полный url (базовый + относительный)
    public CatalogPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    public CatalogPage open() {
        driver.get(url);
        return this;
    }

    public List<String> getAllCourses() {
        return courseCards.stream()
            .map(WebElement::getText)
            .toList();
    }

    public void clickCourseByName(String courseName) {
        WebElement targetElement = courseCards.stream()
            .filter(course -> course.getText().trim().contains(courseName.trim()))
            .findFirst()
            .orElseThrow(() -> new CourseNotFoundException(courseName));

        // Скрипт для прокрутки элемента в центр экрана
        String script = "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});";
        ((JavascriptExecutor) driver).executeScript(script, targetElement);

        targetElement.click();
    }

}