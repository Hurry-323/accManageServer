package com.haorui.service;

import com.haorui.pojo.News;
import com.haorui.pojo.ResultDTO;

public interface NewsService {

    ResultDTO<News> findAllNews();

    ResultDTO<Integer> delNewsById(String id);

    ResultDTO<News> findNewsById(String id);

    ResultDTO<Integer> updateNewsById(News news);

    ResultDTO<Integer> addNews(News news);
}
