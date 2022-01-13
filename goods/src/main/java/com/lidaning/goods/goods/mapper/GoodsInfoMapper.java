package com.lidaning.goods.goods.mapper;

import com.lidaning.goods.goods.domain.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsInfoMapper {

    public GoodsInfo selectGoodsInfoById(String id);

    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo);

    public int insertGoodsInfo(GoodsInfo goodsInfo);

    public int updateGoodsInfo(GoodsInfo goodsInfo);

    public int deleteGoodsInfoById(String id);

    public int deleteGoodsInfoByIds(String[] ids);
}