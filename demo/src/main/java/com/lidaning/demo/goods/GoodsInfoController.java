package com.lidaning.demo.goods;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.supervise.common.annotation.Log;
import com.supervise.common.enums.BusinessType;
import com.supervise.common.core.controller.BaseController;
import com.supervise.common.core.domain.AjaxResult;
import com.supervise.common.core.page.TableDataInfo;


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