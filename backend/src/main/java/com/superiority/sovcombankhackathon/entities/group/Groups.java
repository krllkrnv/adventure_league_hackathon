package com.superiority.sovcombankhackathon.entities.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "students_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<User> students;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_curator")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "group")
    private List<GroupCourseTeacher> groupCourseTeachers;
}
