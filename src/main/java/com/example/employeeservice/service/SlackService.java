package com.example.employeeservice.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@Service
public class SlackService {
    private final RestTemplate restTemplate;

    public SlackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void sendMessageToSlack(String message){
        String url = "https://hooks.slack.com/services/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";
        Map<String,String> messageBuilder = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        messageBuilder.put("text",message);
        HttpEntity<Map<String,String>> request = new HttpEntity<>(messageBuilder,headers);
        restTemplate.postForEntity(url,request,String.class);
    }

//    public void sendMessage(String message) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        String payload = "{\"text\":\"" + message + "\"}";
//
//        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange("https://hooks.slack.com/services/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", HttpMethod.POST, entity, String.class);
//    }
}
