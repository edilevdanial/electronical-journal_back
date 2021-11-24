package com.example.intc_backend.service;

import com.example.intc_backend.dto.NewsDto;
import com.example.intc_backend.dto.NewsSaveRequestDto;

import java.util.List;

public interface NewsService {

    void save(NewsSaveRequestDto newsSaveRequestDto);

    void updateNews(NewsDto newsDto);

    NewsDto findById(Long id);

    List<NewsDto> findAll();

}
