package se.lexicon.daoTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.CourseDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseDaoImplTest {
    static List<Course> courses = new ArrayList<>();
    static CourseDaoImpl courseDao = new CourseDaoImpl();

    @BeforeAll
    static void initAll() {
        courses.add(new Course("Spring Framework Essentials", LocalDate.of(2025, 7, 5), 12));
        courses.add(new Course("Building REST APIs with Spring Boot", LocalDate.of(2025, 7, 25), 9));
        courses.add(new Course("Java Concurrency & Multithreading", LocalDate.of(2025, 8, 10), 11));
        courses.add(new Course("Java Performance Tuning", LocalDate.of(2025, 8, 30), 7));
        courses.add(new Course("JUnit & Test-Driven Development", LocalDate.of(2025, 9, 12), 5));
        courses.add(new Course("Java Design Patterns", LocalDate.of(2025, 9, 28), 8));    }


    @Test
    void saveTest() {
        for(Course course : courses) {
            courseDao.save(course);
        }
        assertEquals(courses, courseDao.findAll());
    }

    @Test
    void findByIdTest() {
        Course actual = courseDao.findById(1);
        Course expected = courses.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void findByNameTest() {
        List<Course> actual = courseDao.findByName("Java");
        List<Course> expected = Arrays.asList(courses.get(2), courses.get(3), courses.get(5));

        assertEquals(expected, actual);
    }

    @Test
    void findByDateTest() {
        Course actual = courseDao.findByDate(LocalDate.of(2025, 7, 5));
        Course expected = courses.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        assertTrue(courseDao.delete(courses.get(0)));
    }
}
