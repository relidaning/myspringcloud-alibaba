package com.lidaning.goods.goods;

import com.supervise.common.annotation.Log;
import com.supervise.common.core.controller.BaseController;
import com.supervise.common.core.domain.AjaxResult;
import com.supervise.common.core.page.TableDataInfo;
import com.supervise.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/goods/goodsInfo")
public class GoodsInfoController extends BaseController{
    @Autowired
    private IGoodsInfoService goodsInfoService;

    @GetMapping("/list")
    public TableDataInfo list(GoodsInfo goodsInfo){
        startPage();
        List<GoodsInfo> list = goodsInfoService.selectGoodsInfoList(goodsInfo);
        return getDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id){
        return AjaxResult.success(goodsInfoService.selectGoodsInfoById(id));
    }

    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsInfo goodsInfo){
        return toAjax(goodsInfoService.insertGoodsInfo(goodsInfo));
    }

    @Log(title = "", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsInfo goodsInfo){
        return toAjax(goodsInfoService.updateGoodsInfo(goodsInfo));
    }

    @Log(title = "", businessType = BusinessType.DELETE)
    @DeleteMapping
    public AjaxResult remove(@PathVariable String[] ids){
        return toAjax(goodsInfoService.deleteGoodsInfoByIds(ids));
    }
}