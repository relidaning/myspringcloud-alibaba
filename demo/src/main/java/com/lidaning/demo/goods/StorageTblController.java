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
}