package com.lidaning.demo.goods;

import java.util.Date;

public class StorageTbl {

    private static final long serialVersionUID = 1L;


    private int id;

    private String commodityCode;

    private int count;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCommoditycode() {
        return commodityCode;
    }

    public void setCommoditycode(String commodityCode){
        this.commodityCode = commodityCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("commodityCode:" + getCommoditycode()+" ")
            .append("count:" + getCount()+" ")
            .toString();
    }
}