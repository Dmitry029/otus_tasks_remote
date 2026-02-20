package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsBasePage {

    protected final WebDriver driver;

    // Конструктор принимает WebDriver, чтобы наследники могли использовать
    protected AbsBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод для открытия страницы (может быть переопределён в наследниках, если нужна навигация)
     */
    public void open() {
        // По умолчанию пусто, если у страницы нет специфичного url
    }

    /**
     * Возвращает текущий WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
}