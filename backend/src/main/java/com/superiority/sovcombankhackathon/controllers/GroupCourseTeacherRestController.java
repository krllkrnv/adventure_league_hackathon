package com.superiority.sovcombankhackathon.controllers;

import com.superiority.sovcombankhackathon.entities.GroupCourseTeacher;
import com.superiority.sovcombankhackathon.service.interf.CRUDService;
import com.superiority.sovcombankhackathon.service.interf.GroupCourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GroupCourseTeacherRestController.GROUPS_COURSE_TEACHER_REST_URL)
public class GroupCourseTeacherRestController extends CRUDRestController<GroupCourseTeacher,Integer> {
    public static final String GROUPS_COURSE_TEACHER_REST_URL="/api/v1/group-course-teacher";
    @Autowired
    private GroupCourseTeacherService groupCourseTeacherService;

    @Override
    CRUDService<GroupCourseTeacher, Integer> getService() {
        return groupCourseTeacherService;
    }
}
