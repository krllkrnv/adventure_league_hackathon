package com.superiority.sovcombankhackathon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.superiority.sovcombankhackathon.entities.courses.Courses;
import com.superiority.sovcombankhackathon.entities.group.Groups;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups_courses_teachers")
public class GroupCourseTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "groups_id", referencedColumnName = "id")
    private Groups group;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Courses course;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User teacher;
}
