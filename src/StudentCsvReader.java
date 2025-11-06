// StudentCsvReader.java
// Reads a CSV file and stores each row as a Student object in an ArrayList.

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentCsvReader {

    public static List<Student> readStudents(Path csvPath) throws IOException {
        List<Student> students = new ArrayList<>();

        // Open the file using a BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            String line;
            boolean isHeader = true;

            // Read each line from the CSV
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (isHeader) { isHeader = false; continue; }
                if (line.isBlank()) continue; // Skip empty lines

                String[] parts = line.split(",", -1); // Split by comma
                if (parts.length < 4) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String course = parts[2].trim();
                    int mark = Integer.parseInt(parts[3].trim());

                    // Add new Student to ArrayList
                    students.add(new Student(id, name, course, mark));

                } catch (NumberFormatException ex) {
                    System.err.println("Skipping invalid number in line: " + line);
                }
            }
        }
        return students;
    }

    public static void main(String[] args) throws IOException {
        Path path = Path.of("data/students.csv");
        List<Student> list = readStudents(path);
        list.forEach(System.out::println);
    }
}
