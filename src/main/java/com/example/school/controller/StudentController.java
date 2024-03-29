/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

package com.example.school.controller;

import java.util.*;
import com.example.school.model.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController {

    @Autowired
    public StudentH2Service studentService;

    @GetMapping("/students")
    public ArrayList<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
    }

}
