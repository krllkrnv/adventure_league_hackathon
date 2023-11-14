package com.superiority.sovcombankhackathon.controllers;

import com.superiority.sovcombankhackathon.entities.courses.Courses;
import com.superiority.sovcombankhackathon.service.interf.CRUDService;
import com.superiority.sovcombankhackathon.service.interf.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CoursesRestController.COURSES_REST_URL)
public class CoursesRestController extends CRUDRestController<Courses,Integer>{
    public static final String COURSES_REST_URL="/api/v1/courses";

    @Autowired
    private CoursesService coursesService;
    @Override
    CRUDService<Courses, Integer> getService() {
        return coursesService;
    }
}
