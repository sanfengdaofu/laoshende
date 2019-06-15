package com.ax.es.service.impl;

import com.ax.domain.Article;
import com.ax.es.dao.ArticleRepository;
import com.ax.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;


    public void saveOne(Article article) {
        articleRepository.save(article);
    }

    public void saveAll(List<Article> articles) {
        articleRepository.saveAll(articles);
    }

    public void deleteById(int i) {
        articleRepository.deleteById(i);
    }

    @Override
    public Page<Article> findByTitle(String title, Pageable page) {
        return articleRepository.findByTitle(title,  page);
    }
}
