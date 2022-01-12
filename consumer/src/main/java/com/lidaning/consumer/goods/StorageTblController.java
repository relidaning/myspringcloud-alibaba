package com.lidaning.consumer.goods;

import com.supervise.common.annotation.Log;
import com.supervise.common.core.controller.BaseController;
import com.supervise.common.core.domain.AjaxResult;
import com.supervise.common.core.page.TableDataInfo;
import com.supervise.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/goods/storageTbl")
public class StorageTblController extends BaseController{
    @Autowired
    private IStorageTblService storageTblService;

    @GetMapping("/list")
    public TableDataInfo list(StorageTbl storageTbl){
        startPage();
        List<StorageTbl> list = storageTblService.selectStorageTblList(storageTbl);
        return getDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id){
        return AjaxResult.success(storageTblService.selectStorageTblById(id));
    }

    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StorageTbl storageTbl){
        return toAjax(storageTblService.insertStorageTbl(storageTbl));
    }

    @Log(title = "", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StorageTbl storageTbl){
        return toAjax(storageTblService.updateStorageTbl(storageTbl));
    }

    @Log(title = "", businessType = BusinessType.DELETE)
    @DeleteMapping
    public AjaxResult remove(@PathVariable String[] ids){
        return toAjax(storageTblService.deleteStorageTblByIds(ids));
    }

    @GetMapping(value = "/deceStorage")
    public AjaxResult deceStorage(){
        int a=1/0;
        StorageTbl store = storageTblService.selectStorageTblById("1");
        store.setCount(store.getCount() - 10);
        storageTblService.updateStorageTbl(store);
        return AjaxResult.success();
    }


}