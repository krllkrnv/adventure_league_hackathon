package com.superiority.sovcombankhackathon.repositories;

import com.superiority.sovcombankhackathon.entities.courses.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}