package com.example.webdevsu19austenkeeneserverjava.controllers;

import com.example.webdevsu19austenkeeneserverjava.models.Course;
import com.example.webdevsu19austenkeeneserverjava.models.Module;
import com.example.webdevsu19austenkeeneserverjava.repositories.CourseRepository;
import com.example.webdevsu19austenkeeneserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/api/module")
    public List<Module> findAllCourses() {
        return (List<Module>) moduleRepository.findAll();
    }

    @GetMapping("/api/module/{mid}")
    public Module findCourseById(@PathVariable("mid") Integer mid) {
        return moduleRepository.findById(mid).orElseThrow(() -> new IllegalArgumentException("No module with this ID exists"));
    }

    @PostMapping("/api/course/{cid}/module")
    public List<Module> createCourse(@PathVariable("cid") Integer cid, @RequestBody String requestBodyString) {
        Course c = courseRepository.findById(cid).orElseThrow(() -> new IllegalArgumentException("No course with this ID exists"));
        Module m = new Module(requestBodyString, c);

        moduleRepository.save(m);
        return (List<Module>) moduleRepository.findAll();
    }

    @DeleteMapping("/api/module/{mid}")
    public void deleteWidget(@PathVariable("mid") Integer mid) {
        moduleRepository.deleteById(mid);
    }

    @PutMapping("/api/module/{mid}")
    public Module updateWidget(@PathVariable("mid") Integer mid, @RequestBody Module module) {
        Module newModule = moduleRepository.findById(mid).orElseThrow(() -> new IllegalArgumentException("No module with this ID exists"));
        newModule.setTitle(module.getTitle());

        moduleRepository.save(newModule);
        return newModule;
    }
}
