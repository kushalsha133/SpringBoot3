package com.kushal.SpringRest.rest;

import com.kushal.SpringRest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    List<Student> theStudent;

    @PostConstruct
    public void loadData(){
        theStudent= new ArrayList<>();
        theStudent.add(new Student("Kushal", "Sharma"));
        theStudent.add(new Student("Aditya", "Jain"));
        theStudent.add(new Student("Kamal", "Shrivastav"));
        theStudent.add(new Student("Hriday", "Chawla"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudent;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        if(id >= theStudent.size() || (id<0)){
            throw new StudentNotFoundException("Student id "+id+" not found!!");
        }
        return theStudent.get(id);
    }

    //Moving these two to StudentRestExceptionHandler
//
//    //Adding ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    //Generic Exception Handler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
