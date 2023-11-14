package com.superiority.sovcombankhackathon.service.implementation;

import com.superiority.sovcombankhackathon.entities.group.Groups;
import com.superiority.sovcombankhackathon.repositories.GroupsRepository;
import com.superiority.sovcombankhackathon.service.interf.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImplementation extends AbstractCRUDService<Groups,Integer> implements GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;
    @Override
    JpaRepository<Groups, Integer> getRepository() {
        return groupsRepository;
    }
}
