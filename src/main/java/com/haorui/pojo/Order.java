package com.haorui.pojo;

public class Order {

    private int id;//订单id
    private String orderNum;//订单号
    private String orderStatus;//订单状态 0-未支付 1- 已支付
    private String orderAmount;//订单金额
    private String createTime;//订单创建时间
    private String paidTime;//订单支付时间

    //生成无参和有参构造函数
    public Order() {
    }

    public Order(int id, String orderNum, String orderStatus, String orderAmount, String createTime, String paidTime) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.createTime = createTime;
        this.paidTime = paidTime;
    }

    //重写toString
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", createTime='" + createTime + '\'' +
                ", paidTime='" + paidTime + '\'' +
                '}';
    }

    //getter和setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
}
