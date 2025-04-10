package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Course {
    private static int sequencer = 0;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.id = getNextId();
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        validateInput(courseName, "Course name");
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        validateInput(startDate, "Start date");
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        validateInput(weekDuration, "Week duration");
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        validateInput(students, "Student list");
        this.students = students;
    }


    public void register(Student student) {
        List<Student> currentStudents = getStudents();
        if(!currentStudents.contains(student)) {
            currentStudents.add(student);
            setStudents(currentStudents);
        } else {
            System.out.printf("The student, %s, is already in this course, %s", student.getName(), this.courseName);
        }
    }

    public void unregister(Student student) {
        List<Student> currentStudents = getStudents();
        if(currentStudents.contains(student)) {
            currentStudents.remove(student);
            setStudents(currentStudents);
        } else {
            throw new NoSuchElementException("The student, " + student.getName() + ", isn't in this course, " + this.courseName);
        }
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }


    private static void validateInput(String input, String inputName) {
        if(input == null || input.isEmpty()) throw new IllegalArgumentException(inputName + " can't be null or empty");
    }
    private static void validateInput(LocalDate input, String inputName) {
        if(input == null) throw new IllegalArgumentException(inputName + " can't be null");
    }
    private static void validateInput(int input, String inputName) {
        if(input < 0) throw new IllegalArgumentException(inputName + " can't be shorter than 0");
    }
    private static void validateInput(List<Student> input, String inputName) {
        if(input == null) throw new IllegalArgumentException(inputName + " can't be null");
    }

    private static int getNextId() {
        return ++sequencer;
    }


}
