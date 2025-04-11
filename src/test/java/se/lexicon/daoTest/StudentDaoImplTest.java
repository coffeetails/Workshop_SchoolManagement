package se.lexicon.daoTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDaoImplTest {
    static List<Student> students = new ArrayList<>();
    static StudentDaoImpl studentDao = new StudentDaoImpl();

    @BeforeAll
    static void initAll() {
        students.add(new Student("Pelle Påhittad", "pellep@protonmail.com", "Långgatan 194, 59382, Kinekullabyn"));
        students.add(new Student("Anna Andersson", "anna.a@example.com", "Myrstigen 7, 11856, Snårstad"));
        students.add(new Student("Johan Johansson", "johan.j@domain.com", "Skymningsvägen 42, 67345, Gråboda"));
        students.add(new Student("Fatima Farrokhzad", "fatima.f@mail.se", "Havrevägen 11, 88231, Vindseleholm"));
        students.add(new Student("Lars Andersson", "lars.l@hotmail.com", "Ekorrbacken 3, 44567, Fjällköping"));
        students.add(new Student("Emelie Ek", "emelie.ek@fantasi.se", "Klockstigen 19, 33912, Mossnäs"));
    }


    @Test
    void saveTest() {
        for(Student student : students) {
            studentDao.save(student);
        }
        assertEquals(students, studentDao.findAll());
    }

    @Test
    void findByEmailTest() {
        Student actual = studentDao.findByEmail("pellep@protonmail.com");
        Student expected = students.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void findByNameTest() {
        List<Student> actual = studentDao.findByName("Andersson");
        List<Student> expected = Arrays.asList(students.get(1), students.get(4));

        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        Student actual = studentDao.findById(1);
        Student expected = students.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        assertTrue(studentDao.delete(students.get(0)));
    }
}
