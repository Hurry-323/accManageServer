package com.haorui.pojo;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String newsAbstract;
    private String text;
    private Date releaseDate;

    //重写toString，方便打印对象
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", newsAbstract='" + newsAbstract + '\'' +
                ", text='" + text + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    //有参构造
    public News(int id, String title, String newsAbstract, String text, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.newsAbstract = newsAbstract;
        this.text = text;
        this.releaseDate = releaseDate;
    }

    //无参构造
    public News() {
    }
    //getter和setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsAbstract() {
        return newsAbstract;
    }

    public void setNewsAbstract(String newsAbstract) {
        this.newsAbstract = newsAbstract;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
