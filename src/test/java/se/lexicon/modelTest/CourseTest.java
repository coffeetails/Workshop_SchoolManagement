package se.lexicon.modelTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    static List<Course> testCourses = new ArrayList<>();
    static List<Student> testStudents = new ArrayList<>();

    @BeforeAll
    static void initAll() {
        testCourses.add(new Course("Java OOP", LocalDate.now(), 10));
        testStudents.add(new Student("Pelle Påhittad", "pellep@protonmail.com", "Långgatan 194, 59382, Kinekullabyn"));
    }

    @Test
    void toStringTest() {
        String actual = testCourses.get(0).toString();
        String expected = "Course{id=1, courseName='Java OOP', startDate=2025-04-10, weekDuration=10, students=[]}";
        assertEquals(expected, actual);
    }

    @Test
    void registerTest() {
        testCourses.get(0).register(testStudents.get(0));

        int actual = testCourses.get(0).getStudents().size();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void removeStudentTest() {
        testCourses.get(0).unregister(testStudents.get(0));

        int actual = testCourses.get(0).getStudents().size();
        int expected = 0;

        assertEquals(expected, actual);
    }

}
