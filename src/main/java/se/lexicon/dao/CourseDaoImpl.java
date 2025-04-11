package se.lexicon.dao;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao {
    List<Course> courses = new ArrayList<>();


    @Override
    public Course save(Course course) {
        if(!courses.contains(course)) {
            courses.add(course);
        } else {
            System.out.println("The course is already saved");
        }
        return course;
    }

    @Override
    public Course findById(int id) {
        for(Course course : courses) {
            if(course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> foundCourses = new ArrayList<>();
        for(Course course : courses) {
            if(course.getCourseName().contains(name)) {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    @Override
    public Course findByDate(LocalDate startDate) {
        for(Course course : courses) {
            if(course.getStartDate() == startDate) {
                return course; // Doesn't work
            }
            if(course.getStartDate().equals(startDate)) {
                return course; // Works
            }
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean delete(Course course) {
        return courses.remove(course); // returns true if successful and false if not

    }
}
