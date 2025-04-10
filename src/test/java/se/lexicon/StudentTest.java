package se.lexicon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    static List<Student> students = new ArrayList<>();

    @BeforeAll
    static void initAll() {
        students.add(new Student("Pelle Påhittad", "pellep@protonmail.com", "Långgatan 194, 59382, Kinekullabyn"));
    }

    @Test
    void studentToStringTest() {
        String actual = students.get(0).toString();
        String expected = "Student{id=1, name='Pelle Påhittad', email='pellep@protonmail.com', address='Långgatan 194, 59382, Kinekullabyn'}";
        assertEquals(expected, actual);
    }
}
