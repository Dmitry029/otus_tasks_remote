package tests;


import org.example.pages.CatalogPage;
import org.example.pages.CoursePage;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

}