package com.haorui.pojo;

public class TransType {
    private String typeId;//类型id
    private String name;//类型名

    //无参构造
    public TransType() {
    }

    //有参
    public TransType(String typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    //方便打印对象
    @Override
    public String toString() {
        return "TransType{" +
                "typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //getter和setter方法
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
