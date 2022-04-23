package com.example.demo;

import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentApi {

    private List<Student> studentList;

    public StudentApi(){
        this.studentList = new ArrayList<>();
    }

    @PostMapping("/AddStudent")
    public boolean addStudent(@RequestBody Student student){
        return studentList.add(student);
    }

    @GetMapping("/StudentList")
    public List<Student> getStudentList(){
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentList.stream().filter(student -> student.getId()==id).findFirst().get();
    }
}
