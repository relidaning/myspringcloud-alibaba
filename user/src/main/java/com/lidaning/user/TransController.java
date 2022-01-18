package com.lidaning.user;

import com.lidaning.user.user.service.IUserService;
import com.sun.media.jfxmedia.logging.Logger;
import com.supervise.common.core.domain.AjaxResult;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Slf4j
@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    IUserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GlobalTransactional(name="buy", rollbackFor = Exception.class)
    @GetMapping("/buy")
    public AjaxResult buy(){
        String xid = RootContext.getXID();
        log.info("###xid={}", xid);
        userService.buy();
        String result = restTemplate.getForObject("http://goods/goods/storageTbl/deceStorage", String.class);
        return AjaxResult.success();
    }

}
