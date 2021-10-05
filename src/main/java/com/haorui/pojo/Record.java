package com.haorui.pojo;

import java.util.Date;

public class Record {
    private String id;//记录id
    private String accountId;//转账方账户id
    private String otherId;//收款方账户id
    private double money;//交易金额
    private Date dateTime;//交易时间
    private String typeId;//交易类型id

    //重写toString方法
    @Override
    public String toString() {
        return "Records{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", otherId='" + otherId + '\'' +
                ", money='" + money + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }

    //有参构造
    public Record(String id, String accountId, String otherId, double money, Date dateTime, String typeId) {
        this.id = id;
        this.accountId = accountId;
        this.otherId = otherId;
        this.money = money;
        this.dateTime = dateTime;
        this.typeId = typeId;
    }
    //无参构造
    public Record() {
    }

    //getter和setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
