package com.lidaning.sentinel.sentineldemo;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelDemoApplication {

    public static void main(String[] args) {
        initFlowRules();
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

    private static void initFlowRules() {
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule method2rule = new FlowRule();
        method2rule.setResource("method2");
        method2rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        method2rule.setCount(1);
        flowRules.add(method2rule);
        FlowRuleManager.loadRules(flowRules);

        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule method3rule = new DegradeRule();
        method3rule.setResource("method3");
        method3rule.setCount(10);       //阈值
        method3rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        method3rule.setTimeWindow(1000*10);  //熔断时长,ms
        degradeRules.add(method3rule);
        DegradeRuleManager.loadRules(degradeRules);
    }

}
