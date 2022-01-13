package com.lidaning.user;

import com.lidaning.user.user.service.IUserService;
import com.supervise.common.core.domain.AjaxResult;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        userService.buy();

        String result = restTemplate.getForObject("http://goods/goods/storageTbl/deceStorage", String.class);
        return AjaxResult.success();
    }

}
