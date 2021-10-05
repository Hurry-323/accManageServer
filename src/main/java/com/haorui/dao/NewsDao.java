package com.haorui.dao;

import com.haorui.pojo.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsDao {

    //查找所有新闻
    @Select("SELECT * FROM news")
    List<News> findAllNews();

    //删除新闻通过id
    @Delete("DELETE FROM news WHERE id = #{id}")
    int delNewsById(String id);

    //根据id查找新闻
    @Select("SELECT * FROM news WHERE id=#{id}")
    News findNewsById(String id);

    //编辑新闻
    @Update("UPDATE news SET title=#{title},newsAbstract=#{newsAbstract},text=#{text} WHERE id=#{id}")
    int updateNewsById(News news);

    //添加新闻
    @Insert("INSERT INTO news(title,newsAbstract,text,releaseDate)VALUES(#{title},#{newsAbstract},#{text},#{releaseDate})")
    int addNews(News news);
}
