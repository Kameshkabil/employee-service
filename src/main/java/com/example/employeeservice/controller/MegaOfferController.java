package com.example.employeeservice.controller;


import com.example.employeeservice.model.Order;
import com.example.employeeservice.service.RuleService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MegaOfferController {
    @Autowired
    private RuleService ruleService;

    @PostMapping("/api/order")
    public Order orderNow(@RequestBody Order order){
        ruleService.applyRules(order);
        return order;
    }
}
