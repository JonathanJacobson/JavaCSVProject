// StudentCsvPipeline.java
// Reads data, filters students, and writes the results to a new CSV file.

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentCsvPipeline {

    public static void main(String[] args) throws IOException {
        Path input = Path.of("data/students.csv");
        Path output = Path.of("data/students_honours.csv");

        // Step 1: Read all students
        List<Student> students = StudentCsvReader.readStudents(input);

        // Step 2: Filter and sort (marks >= 80)
        List<Student> honours = students.stream()
                .filter(s -> s.getMark() >= 80)
                .sorted(Comparator.comparingInt(Student::getMark).reversed()
                        .thenComparing(Student::getName))
                .collect(Collectors.toCollection(ArrayList::new));

        // Step 3: Write to new CSV file
        StudentCsvWriter.writeStudents(output, honours, true);

        System.out.println("Honours list saved to: " + output.toAbsolutePath());
    }
}
