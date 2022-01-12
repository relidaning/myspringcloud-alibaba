package com.lidaning.demo.user;

import java.util.Date;

public class AccountTbl {

    private static final long serialVersionUID = 1L;


    private String id;

    private String userId;

    private int money;



    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userId){
        this.userId = userId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("userId:" + getUserid()+" ")
            .append("money:" + getMoney()+" ")
            .toString();
    }
}