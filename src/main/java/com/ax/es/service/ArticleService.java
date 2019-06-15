package com.ax.es.service;

import com.ax.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    void saveOne(Article article);
    void saveAll(List<Article> articles);

    void deleteById(int i);

    Page<Article> findByTitle(String title, Pageable page);
}
