package com.superiority.sovcombankhackathon.entities.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.superiority.sovcombankhackathon.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "head_name")
    private String headName;
    @Column(name = "division")
    private String division;
    @Column(name = "position")
    private String position;
    @Column(name = "seniority")
    private String seniority;
    @Column(name = "achievements", columnDefinition = "text")
    private String achievements;
    @Column(name = "letter", columnDefinition = "text")
    private String letter;
}
