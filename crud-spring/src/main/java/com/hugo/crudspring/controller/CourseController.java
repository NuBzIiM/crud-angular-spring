package com.hugo.crudspring.controller;

import com.hugo.crudspring.model.Course;
import com.hugo.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED )
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
