package com.haorui.pojo;

public class Accounts {
    private String accountId;//账户id
    private String password;//账户密码
    private double balance;//账户余额
    private String statusId;//状态码
    private int personId;//用户个人编号

    private PersonInfo personInfo;//关联的用户信息

    //重写toString
    @Override
    public String toString() {
        return "Accounts{" +
                "accountId='" + accountId + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", statusId='" + statusId + '\'' +
                ", personId=" + personId +
                ", personInfo=" + personInfo +
                '}';
    }

    //有参构造
    public Accounts(String accountId, String password, double balance, String statusId, int personId, PersonInfo personInfo) {
        this.accountId = accountId;
        this.password = password;
        this.balance = balance;
        this.statusId = statusId;
        this.personId = personId;
        this.personInfo = personInfo;
    }


    //无参构造
    public Accounts() {
    }

    //getter和setter方法
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
