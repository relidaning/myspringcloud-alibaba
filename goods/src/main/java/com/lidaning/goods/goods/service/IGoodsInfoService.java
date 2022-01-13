package com.lidaning.goods.goods.service;

import com.lidaning.goods.goods.domain.GoodsInfo;

import java.util.List;

public interface IGoodsInfoService{

    public GoodsInfo selectGoodsInfoById(String id);

    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo);

    public int insertGoodsInfo(GoodsInfo goodsInfo);

    public int updateGoodsInfo(GoodsInfo goodsInfo);

    public int deleteGoodsInfoByIds(String[] ids);

    public int deleteGoodsInfoById(String id);
}