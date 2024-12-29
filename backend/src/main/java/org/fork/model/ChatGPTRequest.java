package org.fork.model;

import java.util.List;

public class ChatGPTRequest {
    private String model;
    private List<Message> messages;

    // 기본 생성자
    public ChatGPTRequest() {}

    // model과 messages를 인자로 받는 생성자 추가
    public ChatGPTRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    //Getter Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}