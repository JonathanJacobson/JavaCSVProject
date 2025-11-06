// StudentCsvWriter.java
// Writes a list of Student objects to a CSV file.

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StudentCsvWriter {

    public static void writeStudents(Path csvPath, List<Student> students, boolean includeHeader)
            throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8)) {

            if (includeHeader) {
                writer.write("id,name,course,mark");
                writer.newLine();
            }

            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getCourse() + "," + s.getMark());
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<Student> students = List.of(
                new Student(10, "Lerato Mokoena", "Algorithms", 88),
                new Student(11, "Daniel Cho", "Java Basics", 74)
        );

        Path output = Path.of("data/students_out.csv");
        writeStudents(output, students, true);
        System.out.println("File written: " + output.toAbsolutePath());
    }
}
