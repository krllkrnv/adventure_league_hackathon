package com.superiority.sovcombankhackathon.controllers.dto;

import com.superiority.sovcombankhackathon.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Integer id;
    private String headName;
    private String division;
    private String position;
    private String seniority;
    private String achievements;
    private String letter;
}
