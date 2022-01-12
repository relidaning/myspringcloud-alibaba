package com.lidaning.demo.goods;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsInfoMapper {

    public GoodsInfo selectGoodsInfoById(String id);

    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo);

    public int insertGoodsInfo(GoodsInfo goodsInfo);

    public int updateGoodsInfo(GoodsInfo goodsInfo);

    public int deleteGoodsInfoById(String id);

    public int deleteGoodsInfoByIds(String[] ids);
}