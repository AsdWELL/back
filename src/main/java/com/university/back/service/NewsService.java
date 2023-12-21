package com.university.back.service;


import com.university.back.model.News;
import com.university.back.repository.NewsRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private NewsRepos newRepos;

    public void deleteNewsById(long id){ newRepos.deleteNewsById(id); }

    public void updateNewsById(News newNews) {
        newRepos.updateNewsById(newNews.getId(), newNews);
    }

    public List<News> getAllNews(long id){
        var news = newRepos.findNewsById(id);
        if(news == null) return null;
        return newRepos.findAllNews();
    }
}
