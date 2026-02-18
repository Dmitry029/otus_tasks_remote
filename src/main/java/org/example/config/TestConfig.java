package org.example.config;

import org.example.pages.CatalogPage;
import org.example.pages.CoursePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Value("${browser}")
    private String browser;

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
        WebDriver driver = WebDriverFactory.create(browser);
        WebDriverListener listener = new HighlightingListener();
        return new EventFiringDecorator(listener).decorate(driver);
    }

    @Bean
    public CatalogPage catalogPage(WebDriver driver, @Value("${base.url}") String baseUrl) {
        return new CatalogPage(driver, baseUrl + "/catalog/courses");
    }

    @Bean
    public CoursePage coursePage(WebDriver driver) {
        return new CoursePage(driver);
    }
}