package student_api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Ahmed", 88.5));
        students.add(new Student(2, "Osama", 92.0));
        students.add(new Student(3, "Sara", 79.3));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Osama, your API is working!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/students/search")
    public Student getStudentByName(@RequestParam String name){
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public void removeStudent(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(student.getName());
                s.setAverage(student.getAverage());
                return;
            }
        }
    }
    
}
