package com.example.employeeservice.controller;

import com.example.employeeservice.model.SlackMessage;
import com.example.employeeservice.service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SlackController {
    @Autowired
    SlackService slackService;

    @PostMapping("/slack")
    public void sendMessage(@RequestBody SlackMessage slackMessage){
        String message =slackMessage.getMessage() + " " + slackMessage.getEmoji();
        slackService.sendMessageToSlack(message);
    }
}
