// Student.java
// Model class representing a student record from the CSV file.

public class Student {
    private final int id;
    private final String name;
    private final String course;
    private final int mark;

    // Constructor to initialize student fields
    public Student(int id, String name, String course, int mark) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mark = mark;
    }

    // Getter methods for each field
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getMark() { return mark; }

    // toString() used for easy printing
    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', course='%s', mark=%d}",
                id, name, course, mark);
    }
}
