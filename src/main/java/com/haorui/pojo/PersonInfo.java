package com.haorui.pojo;

import java.util.Date;

public class PersonInfo {

    private int personId;//用户id
    private String realName;//真实姓名
    private Date birthday;//生日
    private String sex;//性别
    private String cardId;//身份证
    private String address;//地址
    private String telephone;//电话
    private String mail;//邮箱

    //重写toString
    @Override
    public String toString() {
        return "personInfo{" +
                "personId=" + personId +
                ", realName='" + realName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    //有参构造
    public PersonInfo(int personId, String realName, Date birthday, String sex, String cardId, String address, String telephone, String mail) {
        this.personId = personId;
        this.realName = realName;
        this.birthday = birthday;
        this.sex = sex;
        this.cardId = cardId;
        this.address = address;
        this.telephone = telephone;
        this.mail = mail;
    }
    public PersonInfo(String realName, Date birthday, String sex, String cardId, String address, String telephone, String mail) {
        this.realName = realName;
        this.birthday = birthday;
        this.sex = sex;
        this.cardId = cardId;
        this.address = address;
        this.telephone = telephone;
        this.mail = mail;
    }

    //无参构造
    public PersonInfo() {
    }

    //getter和setter方法
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
