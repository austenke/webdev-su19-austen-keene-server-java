package com.example.webdevsu19austenkeeneserverjava.controllers;

import com.example.webdevsu19austenkeeneserverjava.models.Course;
import com.example.webdevsu19austenkeeneserverjava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/api/course")
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @GetMapping("/api/course/{cid}")
    public Course findCourseById(@PathVariable("cid") Integer cid) {
        return courseRepository.findById(cid).orElseThrow(() -> new IllegalArgumentException("No course with this ID exists"));
    }

    @PostMapping("/api/course")
    public List<Course> createCourse(@RequestBody String requestBodyString) {
        Course c = new Course(requestBodyString,  new ArrayList<>());

        courseRepository.save(c);
        return (List<Course>) courseRepository.findAll();
    }

    @DeleteMapping("/api/course/{cid}")
    public void deleteWidget(@PathVariable("cid") Integer cid) {
        courseRepository.deleteById(cid);
    }

    @PutMapping("/api/course/{cid}")
    public Course updateWidget(@PathVariable("cid") Integer cid, @RequestBody Course course) {
        courseRepository.save(course);
        return course;
    }
}
