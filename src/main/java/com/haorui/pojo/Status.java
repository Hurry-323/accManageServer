package com.haorui.pojo;

public class Status {
    private String statusId;//状态编码id
    private String name;//状态名

    //重写
    @Override
    public String toString() {
        return "Status{" +
                "statusId='" + statusId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //无参构造
    public Status() {
    }

    //有参构造
    public Status(String statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    //getter和setter方法
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
