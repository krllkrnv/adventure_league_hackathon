package com.superiority.sovcombankhackathon.service.implementation;

import com.superiority.sovcombankhackathon.entities.application.Application;
import com.superiority.sovcombankhackathon.repositories.ApplicationRepository;
import com.superiority.sovcombankhackathon.service.interf.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImplementation extends AbstractCRUDService<Application,Integer> implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    JpaRepository<Application, Integer> getRepository() {
        return applicationRepository;
    }
}
