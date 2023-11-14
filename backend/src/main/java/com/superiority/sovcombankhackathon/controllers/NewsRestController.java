package com.superiority.sovcombankhackathon.controllers;

import com.superiority.sovcombankhackathon.entities.News;
import com.superiority.sovcombankhackathon.service.interf.CRUDService;
import com.superiority.sovcombankhackathon.service.interf.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/news")
public class NewsRestController extends CRUDRestController<News, Integer>{
    @Autowired
    private NewsService newsService;
    @Override
    CRUDService<News, Integer> getService() {
        return newsService;
    }
}
