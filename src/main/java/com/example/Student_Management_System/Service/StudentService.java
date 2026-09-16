package com.example.Student_Management_System.Service;

import com.example.Student_Management_System.Entity.Student;
import com.example.Student_Management_System.Exception.EmailAlreadyExistsException;
import com.example.Student_Management_System.Exception.StudentNotFoundException;
import com.example.Student_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student){

        if(repository.existsByEmail(student.getEmail())){
            throw new EmailAlreadyExistsException("Student with email " + student.getEmail() + " already exists");
        }
        return repository.save(student);
    }

    public List<Student> getAllStudents(){
       List<Student>allStudents=repository.findAll();
       if(allStudents.isEmpty()) {
           throw new StudentNotFoundException("No students found");
       }
         return allStudents;

    }

    public Student getStudentById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student student){
        Student existingStudent = repository.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not found with id: " + id));

            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCourse(student.getCourse());
            return repository.save(existingStudent);

    }

    public void deleteStudent(Long id){
        Student student=repository.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not found with id: " + id));
        repository.delete(student);
    }




}