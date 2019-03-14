package com.ytt.aaron_demo.po;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:37 2019/3/8
 * @Modiflid By:
 */
public class City {

    private long id;
    private String name;
    private String state;
    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getState() + "," + getCountry();
    }

}
