package com.lidaning.sentinel.sentineldemo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/method")
    public String method(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                return "hello, sentinel!";
            } catch (BlockException e1) {
                return "oops, blocked!";
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    @GetMapping("/method2")
    @SentinelResource(value = "method2",blockHandler = "exceptionHandler")
    public String method2(){
        log.info("exec method:method2");
        return "hello, sentinel!";
    }

    public String exceptionHandler(BlockException ex){
        log.error("Oops, blocked!");
        return "Oops, blocked!";
    }


}
