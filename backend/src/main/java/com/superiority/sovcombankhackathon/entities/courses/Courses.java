package com.superiority.sovcombankhackathon.entities.courses;

import com.superiority.sovcombankhackathon.entities.GroupCourseTeacher;
import com.superiority.sovcombankhackathon.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "description",columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "course")
    private List<GroupCourseTeacher> groupCourseTeachers;


}
