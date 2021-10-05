package com.haorui.pojo;

import java.util.List;


public class ResultDTO<T> {
    private int code = 0;//存储状态码
    private String msg = "";//存储状态信息
    private T data;//保存单个数据
    private List<T> datas;//保存多个数据
    private String token = "";//用户状态信息

    //生成有参、无参构造方法  set get方法 toString 方法


    public ResultDTO(int code, String msg, T data, List<T> datas, String token) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.datas = datas;
        this.token = token;
    }

    public ResultDTO() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", datas=" + datas +
                ", token='" + token + '\'' +
                '}';
    }

}
