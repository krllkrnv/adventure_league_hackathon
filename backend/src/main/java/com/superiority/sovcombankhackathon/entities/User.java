package com.superiority.sovcombankhackathon.entities;

import com.superiority.sovcombankhackathon.entities.application.Application;
import com.superiority.sovcombankhackathon.entities.courses.Courses;
import com.superiority.sovcombankhackathon.entities.group.Groups;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@Builder
//@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "telegram")
    private String telegram;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Application> applications;

    @OneToMany(mappedBy = "user")
    private List<Groups> groups;

    @OneToMany(mappedBy = "teacher")
    private List<GroupCourseTeacher> groupCourseTeachers;

    @ManyToMany(mappedBy = "students")
    private List<Groups> groupsStudent;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
