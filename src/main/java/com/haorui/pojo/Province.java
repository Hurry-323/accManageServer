package com.haorui.pojo;

public class Province {
    private int id;
    private String province;
    private String shortName;
    private String centerCity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCenterCity() {
        return centerCity;
    }

    public void setCenterCity(String centerCity) {
        this.centerCity = centerCity;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", shortName='" + shortName + '\'' +
                ", centerCity='" + centerCity + '\'' +
                '}';
    }

    public Province(int id, String province, String shortName, String centerCity) {
        this.id = id;
        this.province = province;
        this.shortName = shortName;
        this.centerCity = centerCity;
    }

    public Province() {
    }
}
