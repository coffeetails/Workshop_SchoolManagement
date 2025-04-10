package se.lexicon.dao;

import se.lexicon.model.Course;

import java.util.List;

public interface ICourseDao {
    Course save(Course course);
    Course findByEmail(String email);
    List<Course> findByName(String name);
    Course findById(int id);
    List<Course> findAll();
    boolean delete(Course course);
}
