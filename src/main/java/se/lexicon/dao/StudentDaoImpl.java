package se.lexicon.dao;

import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    List<Student> students = new ArrayList<>();


    @Override
    public Student save(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        } else {
            System.out.println("The student is already saved");
        }
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student : students) {
            if(student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for(Student student : students) {
            if(student.getName().contains(name)) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    @Override
    public Student findById(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean delete(Student student) {
        return students.remove(student); // returns true if successful and false if not
    }

}
