package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogPage {

    private final WebDriver driver;
    private final String url;

    public CatalogPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void open() {
        driver.get(url);
    }

    /**
     * Возвращает список курсов на странице в виде списка плиток
     */
    public List<CourseTile> getAllCourses() {
        List<WebElement> courseElements = driver.findElements(By.cssSelector(".course-card"));
        return courseElements.stream()
                             .map(CourseTile::new)
                             .collect(Collectors.toList());
    }

    /**
     * Ищет курс по имени с использованием Stream API. 
     * Возвращает Optional<CourseTile>
     */
    public Optional<CourseTile> findCourseByName(String name) {
        return getAllCourses().stream()
            .filter(tile -> tile.getCourseName().equalsIgnoreCase(name))
            .findFirst();
    }
}