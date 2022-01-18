package com.lidaning.goods.goods.controller;

import com.lidaning.goods.goods.service.IStorageTblService;
import com.lidaning.goods.goods.domain.StorageTbl;
import com.supervise.common.annotation.Log;
import com.supervise.common.core.controller.BaseController;
import com.supervise.common.core.domain.AjaxResult;
import com.supervise.common.core.page.TableDataInfo;
import com.supervise.common.enums.BusinessType;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
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
    public AjaxResult deceStorage() throws TransactionException {
        try{
            String xid = RootContext.getXID();
            logger.debug("###xid:"+xid);
//            int a=1/0;
            StorageTbl store = storageTblService.selectStorageTblById("1");
            store.setCount(store.getCount() - 10);
            storageTblService.updateStorageTbl(store);
            return AjaxResult.success();
        }catch (Exception e){
            logger.error(e.getMessage());
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            return AjaxResult.error(e.getMessage());
        }

    }


}