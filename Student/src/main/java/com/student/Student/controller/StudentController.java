package com.student.Student.controller;

import com.student.Student.entity.Student;
import com.student.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //for adding Student
    @PostMapping("/add")
    public Student add(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    //for getting Student
    @GetMapping("/get")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }
    //for updating the Student detail using id
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") Long id) throws Exception {
        return studentService.updateStudent(student,id);
    }
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return HttpStatus.MOVED_PERMANENTLY;
    }

    /////for multple students

    @PostMapping("/addMultiple")
    public List<Student> addStudentMultiple(@RequestBody List<Student> student){
        return studentService.addStudentMultiple(student);
    }

}
