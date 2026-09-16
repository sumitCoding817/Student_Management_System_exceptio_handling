package com.example.Student_Management_System.Controller;

import com.example.Student_Management_System.Entity.Student;
import com.example.Student_Management_System.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;


    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student){
        Student save = service.createStudent(student);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student> allStudents = service.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = service.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student updateStudent = service.updateStudent(id, student);

        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);

        return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
    }
}
