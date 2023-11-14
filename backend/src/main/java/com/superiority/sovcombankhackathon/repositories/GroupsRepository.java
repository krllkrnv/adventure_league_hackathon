package com.superiority.sovcombankhackathon.repositories;

import com.superiority.sovcombankhackathon.entities.group.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {
}