package com.superiority.sovcombankhackathon.controllers;

import com.superiority.sovcombankhackathon.entities.application.Application;
import com.superiority.sovcombankhackathon.service.interf.ApplicationService;
import com.superiority.sovcombankhackathon.service.interf.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationRestController.APPLICATION_REST_URL)
public class ApplicationRestController extends CRUDRestController<Application,Integer> {
    public static final String APPLICATION_REST_URL="/api/v1/application";
    @Autowired
    private ApplicationService applicationService;
    @Override
    CRUDService<Application, Integer> getService() {
        return applicationService;
    }
}
