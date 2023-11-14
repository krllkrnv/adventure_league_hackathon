package com.superiority.sovcombankhackathon.service.implementation;

import com.superiority.sovcombankhackathon.entities.News;
import com.superiority.sovcombankhackathon.repositories.NewsRepository;
import com.superiority.sovcombankhackathon.service.interf.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsServiceImplementation extends AbstractCRUDService<News, Integer> implements NewsService {
    private final NewsRepository newsRepository;
    @Override
    JpaRepository<News, Integer> getRepository() {
        return newsRepository;
    }
}
