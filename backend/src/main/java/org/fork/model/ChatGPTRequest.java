package org.fork.model;

public class ChatGPTRequest {
    private String prompt;

    public ChatGPTRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}