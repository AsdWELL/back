package com.university.back.repository;

import com.university.back.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepos extends JpaRepository<News, Long> {

    void deleteNewsById(long id);
    News findNewsById(long id);

    void updateNewsById(long id, News news);

    @Query("select n from News n")
    List<News> findAllNews();
}
