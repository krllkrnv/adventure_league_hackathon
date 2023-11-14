package com.superiority.sovcombankhackathon.controllers;

import com.superiority.sovcombankhackathon.entities.group.Groups;
import com.superiority.sovcombankhackathon.service.interf.CRUDService;
import com.superiority.sovcombankhackathon.service.interf.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GroupsRestController.GROUPS_REST_URL)
public class GroupsRestController extends CRUDRestController<Groups,Integer> {
    public static final String GROUPS_REST_URL="/api/v1/groups";
    @Autowired
    private GroupsService groupsService;

    @Override
    CRUDService<Groups, Integer> getService() {
        return groupsService;
    }
}
