package test_data;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

public class CourseData {

    public static Stream<Arguments> loadCourses() throws IOException {
        Properties prop = new Properties();

        // Загрузка properties с utf-8 через InputStreamReader
        try (InputStream input = CourseData.class.getClassLoader().getResourceAsStream("courses/properties")) {
            if (input == null) {
                throw new IOException("Файл courses.properties не найден");
            }
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        }

        // Собираем уникальные индексы курсов, по ключам "course.<index>.name"
        Set<String> indexes = new HashSet<>();

        for (String key : prop.stringPropertyNames()) {
            if (key.startsWith("course.") && key.endsWith(".name")) {
                // ключ вида course.1.name => вытаскиваем "1"
                String index = key.substring("course.".length(), key.length() - ".name".length());
                indexes.add(index);
            }
        }

        // Создаем поток Arguments по индексам
        return indexes.stream()
            .map(index -> {
                String name = prop.getProperty("course." + index + ".name");
                String url = prop.getProperty("course." + index + ".url");
                return Arguments.of(name, url);
            });
    }
}