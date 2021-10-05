package com.haorui.controller;


import com.haorui.pojo.News;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    //查找所有新闻
    @GetMapping("/findAllNews")
    public @ResponseBody ResultDTO<News> findAllNews(){
        return newsService.findAllNews();
    }

    //删除新闻
    @GetMapping("/delNewsById")
    public @ResponseBody ResultDTO<Integer> delNewsById(String id){
        System.out.println(id);
        return newsService.delNewsById(id);
    }

    //根据id查找新闻
    @GetMapping("/findNewsById")
    public @ResponseBody ResultDTO<News> findNewsById(String id){
        System.out.println(id);
        return newsService.findNewsById(id);

    }

    //编辑新闻
    @PostMapping("/updateNewsById")
    public @ResponseBody ResultDTO<Integer> updateNewsById(@RequestBody News news){
        //打印前台值
        System.out.println(news.toString());



        return newsService.updateNewsById(news);
    }

    //添加新闻
    @PostMapping("/addNews")
    public @ResponseBody ResultDTO<Integer> addNews(@RequestBody News news){
        //打印前台值
        System.out.println(news.toString());

        news.setReleaseDate(new Date());


        return newsService.addNews(news);
    }
}
