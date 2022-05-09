package com.student.Student.service;

import com.student.Student.entity.Student;
import com.student.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
@Autowired
    StudentRepo studentRepo;
    public Student addStudent(Student student){
        return studentRepo.save(student);
    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    public Student updateStudent(Student student,Long id) throws Exception {
        return studentRepo.findById(id).map(student1 -> {
            student1.setName(student.getName());
            student1.setContact(student.getContact());
            student1.setMail(student.getMail());
            return (studentRepo.save(student1));
        }).orElseThrow(() -> new Exception("ID Not Found" + " " + id));
    }

    public void deleteStudent(Long id){
         studentRepo.deleteById(id);
    }

    ///for adding multiple students
    public List<Student> addStudentMultiple(List<Student> student){
        return studentRepo.saveAll(student);
    }
}
