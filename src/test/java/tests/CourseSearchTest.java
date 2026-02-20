package tests;


import org.assertj.core.api.Assertions;
import org.example.pages.CatalogPage;
import org.example.pages.CoursePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = org.example.config.TestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseSearchTest {

    private final CatalogPage catalogPage;
    private final CoursePage coursePage;

    @Autowired
    public CourseSearchTest(CatalogPage catalogPage, CoursePage coursePage) {
        this.catalogPage = catalogPage;
        this.coursePage = coursePage;
    }

    @ParameterizedTest
    @MethodSource("test_data.CourseData#loadCourses")
    public void searchCourse(String expectedCourseTitle, String expectedUrl) {
        catalogPage
            .open()
            .clickCourseByName(expectedCourseTitle);

        assertThat(expectedUrl).isEqualTo(coursePage.getCurrentUrl());
        assertThat(expectedCourseTitle).isEqualTo(coursePage.getCourseTitle());
    }

}