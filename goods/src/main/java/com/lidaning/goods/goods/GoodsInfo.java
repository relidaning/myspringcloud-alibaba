package com.lidaning.goods.goods;

public class GoodsInfo {

    private static final long serialVersionUID = 1L;


    private int id;

    private String goodName;

    private Float price;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getGoodname() {
        return goodName;
    }

    public void setGoodname(String goodName){
        this.goodName = goodName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price){
        this.price = price;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("goodName:" + getGoodname()+" ")
            .append("price:" + getPrice()+" ")
            .toString();
    }
}