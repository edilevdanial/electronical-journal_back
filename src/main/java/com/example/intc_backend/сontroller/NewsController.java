package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.NewsDto;
import com.example.intc_backend.dto.NewsSaveRequestDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping(value = "create-news")
    public ResponseEntity<?> createNews(@RequestBody NewsSaveRequestDto newsSaveRequestDto){
        newsService.save(newsSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/news/{id}")
    public ResponseEntity<NewsDto> findNewsById(@PathVariable(name = "id")Long id){
        NewsDto newsDto =  newsService.findById(id);

        return ResponseEntity.ok(newsDto);
    }

    @PostMapping(value = "/news/{id}")
    public ResponseEntity<NewsDto> updateNewsById(@PathVariable(name = "id")Long id,@RequestParam(name = "preview")String preview,@RequestParam(name = "name")String name,@RequestParam(name = "description")String description){
        NewsDto newsDto =  newsService.findById(id);
        System.out.println(newsDto.getName()+""+newsDto.getPreview());
        if (!name.equals("null")){
            newsDto.setName(name);
        }
        if (!description.equals("null")){
            newsDto.setName(description);
        }
        if(!preview.equals("null")){
            newsDto.setPreview(preview);
        }
        newsService.updateNews(newsDto);

        return ResponseEntity.ok(newsDto);
    }

    @GetMapping(value = "/news")
    public ResponseEntity<List<NewsDto>> findAllNewsList(){
        List<NewsDto> userDtoList = newsService.findAll();

        return ResponseEntity.ok(userDtoList);
    }


}
