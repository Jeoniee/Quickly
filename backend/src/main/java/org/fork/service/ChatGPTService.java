package org.fork.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.fork.model.ChatGPTRequest;
import org.fork.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ChatGPTService {
    @Value("${OpenApiKey}")
    private String API_KEY;
    @Value("${OpenApiUrl}")
    private String API_URL;

    public String getChatGPTResponse(String prompt) throws Exception {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(new Message("user", prompt));

        ChatGPTRequest chatGPTRequest = new ChatGPTRequest(model, messages);

        // ChatGPTRequest 객체를 JSON으로 변환
        String json = objectMapper.writeValueAsString(chatGPTRequest);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body() == null ? null : response.body().string();
        }
    }

    public String getRecommendation(Map<String, Object> location, Map<String, Object> weather) throws Exception {
        String prompt = "Location: " + location + ", Weather: " + weather + ". Recommend a lunch menu.";
        return getChatGPTResponse(prompt);
    }
}
