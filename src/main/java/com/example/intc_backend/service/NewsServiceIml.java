package com.example.intc_backend.service;

import com.example.intc_backend.dto.NewsDto;
import com.example.intc_backend.dto.NewsSaveRequestDto;
import com.example.intc_backend.model.News;
import com.example.intc_backend.repository.NewsRepository;
import com.example.intc_backend.util.NewsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceIml implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void save(NewsSaveRequestDto newsSaveRequestDto) {

        newsRepository.save(NewsUtil.toNews(newsSaveRequestDto));
    }

    @Override
    public NewsDto findById(Long id) {
        NewsDto newsDto = NewsUtil.toNewsDto(newsRepository.getById(id));

        return newsDto;
    }

    @Override
    public void updateNews(NewsDto newsDto) {
        News news = NewsUtil.toNews(newsDto);
        newsRepository.save(news);
    }

    @Override
    public List<NewsDto> findAll() {
        List<NewsDto> newsDtoList = NewsUtil.toNewsDtoList(newsRepository.findAll());

        return newsDtoList;
    }
}
