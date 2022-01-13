package com.lidaning.goods.goods;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{
    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public GoodsInfo selectGoodsInfoById(String id){
        return goodsInfoMapper.selectGoodsInfoById(id);
    }

    @Override
    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo){
        return goodsInfoMapper.selectGoodsInfoList(goodsInfo);
    }

    @Override
    public int insertGoodsInfo(GoodsInfo goodsInfo){
        return goodsInfoMapper.insertGoodsInfo(goodsInfo);
    }

    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo){
        return goodsInfoMapper.updateGoodsInfo(goodsInfo);
    }

    @Override
    public int deleteGoodsInfoByIds(String[] ids){
        return goodsInfoMapper.deleteGoodsInfoByIds(ids);
    }

    @Override
    public int deleteGoodsInfoById(String id){
        return goodsInfoMapper.deleteGoodsInfoById(id);
    }
}