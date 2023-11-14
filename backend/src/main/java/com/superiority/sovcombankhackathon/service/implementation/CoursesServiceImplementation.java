package com.superiority.sovcombankhackathon.service.implementation;

import com.superiority.sovcombankhackathon.entities.courses.Courses;
import com.superiority.sovcombankhackathon.repositories.CoursesRepository;
import com.superiority.sovcombankhackathon.service.interf.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImplementation extends AbstractCRUDService<Courses,Integer> implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
    @Override
    JpaRepository<Courses, Integer> getRepository() {
        return coursesRepository;
    }
}
