package com.lidaning.demo;

import com.lidaning.demo.goods.IGoodsInfoService;
import com.lidaning.demo.goods.IStorageTblService;
import com.lidaning.demo.goods.StorageTbl;
import com.lidaning.demo.user.AccountTbl;
import com.lidaning.demo.user.IAccountTblService;
import com.lidaning.demo.user.IUserService;
import com.supervise.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    IUserService userService;
    @Autowired
    IAccountTblService accountTblService;
    @Autowired
    IGoodsInfoService goodsInfoService;
    @Autowired
    IStorageTblService storageTblService;

    @Transactional
    @GetMapping("/buy")
    public AjaxResult buy(){
        StorageTbl store = storageTblService.selectStorageTblById("1");
        store.setCount(store.getCount() - 10);
        storageTblService.updateStorageTbl(store);

        int a = 1/0;

        AccountTbl account = accountTblService.selectAccountTblById("1");
        account.setMoney(account.getMoney() - 10*5);
        accountTblService.updateAccountTbl(account);

        return AjaxResult.success();
    }

}
