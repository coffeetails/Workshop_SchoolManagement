package se.lexicon.model;

public class Student {
    private static int sequencer = 0;
    private int id;
    private String name;
    private String email;
    private String address;

    public Student(String name, String email, String address) {
        this.id = getNextId();
        setName(name);
        setEmail(email);
        setAddress(address);
    }


    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateInput(address, "Address");
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateInput(email, "Email");
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateInput(name, "Name");
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



    private static int getNextId() {
        return ++sequencer;
    }

    private static void validateInput(String input, String inputName) {
        if(input == null || input.isEmpty()) throw new IllegalArgumentException(inputName + " can't be null or empty");
    }

}
