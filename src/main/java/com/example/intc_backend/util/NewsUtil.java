package com.example.intc_backend.util;

import com.example.intc_backend.dto.NewsDto;
import com.example.intc_backend.dto.NewsSaveRequestDto;
import com.example.intc_backend.model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsUtil {

    public static NewsDto toNewsDto(News news){
        if (news==null)return null;
        NewsDto newsDto = new NewsDto();

        newsDto.setId(news.getId());
        newsDto.setPreview(news.getPreview());
        newsDto.setName(news.getName());
        newsDto.setDescription(news.getDescription());

        return  newsDto;
    }
    public static News toNews(NewsSaveRequestDto newsSaveRequestDto){
        if (newsSaveRequestDto==null)return null;

        News news = new News();

        news.setDescription(newsSaveRequestDto.getDescription());
        news.setName(newsSaveRequestDto.getName());
        news.setPreview(newsSaveRequestDto.getPreview());

        return news;
    }
    public static News toNews(NewsDto newsDto){
        if (newsDto==null)return null;

        News news = new News();

        news.setDescription(newsDto.getDescription());
        news.setName(newsDto.getName());
        news.setPreview(newsDto.getPreview());
        news.setId(newsDto.getId());

        return news;
    }


    public static List<NewsDto> toNewsDtoList(List<News> newsList){
        if (newsList==null)return null;

        List<NewsDto> newsDtoList = new ArrayList<>();

        for (News news:newsList){
            newsDtoList.add(toNewsDto(news));
        }

        return newsDtoList;
    }
}
