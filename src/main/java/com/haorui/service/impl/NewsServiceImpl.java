package com.haorui.service.impl;

import com.haorui.dao.NewsDao;
import com.haorui.pojo.News;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDao newsDao;

    //查找所有新闻
    @Override
    public ResultDTO<News> findAllNews() {
        //定义规范返回对象
        ResultDTO<News> resultDTO = new ResultDTO<>();

        resultDTO.setDatas(newsDao.findAllNews());
        resultDTO.setCode(8888);

        return resultDTO;
    }

    //删除新闻
    @Override
    public ResultDTO<Integer> delNewsById(String id) {
        //定义规范返回对象
        ResultDTO<Integer> resultDTO = new ResultDTO<>();

        if(newsDao.delNewsById(id)>0){
            resultDTO.setMsg("删除成功");
            resultDTO.setCode(8888);
        }else{
            resultDTO.setMsg("删除失败");
            resultDTO.setCode(1004);
        }

        return resultDTO;
    }

    //通过id查找新闻
    @Override
    public ResultDTO<News> findNewsById(String id) {
        //定义规范返回对象
        ResultDTO<News> resultDTO = new ResultDTO<>();

        News news = newsDao.findNewsById(id);

        if(null!=news){
            resultDTO.setMsg("查找成功");
            resultDTO.setData(news);
            resultDTO.setCode(8888);
        }else{
            resultDTO.setMsg("文章不存在");
            resultDTO.setCode(1004);
        }

        return resultDTO;
    }

    //更新新闻信息
    @Override
    public ResultDTO<Integer> updateNewsById(News news) {
        //定义规范返回对象
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        if(newsDao.updateNewsById(news)>0){
            resultDTO.setMsg("修改成功");
            resultDTO.setCode(8888);
        }else{
            resultDTO.setMsg("修改失败");
            resultDTO.setCode(1004);
        }


        return resultDTO;
    }

    //添加新闻
    @Override
    public ResultDTO<Integer> addNews(News news) {
        //定义规范返回对象
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        if(newsDao.addNews(news)>0){
            resultDTO.setMsg("添加成功");
            resultDTO.setCode(8888);
        }else{
            resultDTO.setMsg("添加失败");
            resultDTO.setCode(1004);
        }
        return resultDTO;
    }
}
