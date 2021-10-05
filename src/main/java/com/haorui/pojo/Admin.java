package com.haorui.pojo;

public class Admin {

    private int id;//管理员id
    private String adminName;//管理员登录名
    private String adminPassword;//管理员密码
    private String adminStatus;//管理员状态（是否已修改密码）
    //重写方便打印对象
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminStatus='" + adminStatus + '\'' +
                '}';
    }

    //有参构造
    public Admin(int id, String adminName, String adminPassword, String adminStatus) {
        this.id = id;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminStatus = adminStatus;
    }
    //无参构造
    public Admin() {
    }
    //getter和setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }
}
