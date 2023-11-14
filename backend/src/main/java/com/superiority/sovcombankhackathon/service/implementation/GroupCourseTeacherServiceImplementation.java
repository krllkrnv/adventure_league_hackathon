package com.superiority.sovcombankhackathon.service.implementation;

import com.superiority.sovcombankhackathon.entities.GroupCourseTeacher;
import com.superiority.sovcombankhackathon.repositories.GroupCourseTeacherRepository;
import com.superiority.sovcombankhackathon.service.interf.GroupCourseTeacherService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupCourseTeacherServiceImplementation extends AbstractCRUDService<GroupCourseTeacher,Integer> implements GroupCourseTeacherService {
    @Autowired
    private GroupCourseTeacherRepository groupCourseTeacherRepository;
    @Override
    JpaRepository<GroupCourseTeacher, Integer> getRepository() {
        return groupCourseTeacherRepository;
    }
}
