package org.fork.controller;

import org.fork.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RecommendController {
    @Autowired()
    private ChatGPTService chatGPTService;

    @PostMapping("/recommend")
    public String getRecommendation(@RequestBody Map<String, Object> payload) {
        try {
            Map<String, Object> location = (Map<String, Object>) payload.get("location");
            Map<String, Object> weather = (Map<String, Object>) payload.get("weather");

            // 위치와 날씨 정보를 기반으로 추천 메뉴 생성
            return chatGPTService.getRecommendation(location, weather);
        } catch (Exception e) {
            return "Error generating recommendation: " + e.getMessage();
        }
    }
}
