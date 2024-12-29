package org.fork.model;
public class Message {
    private String role; // 'user', 'system', 'assistant' 중 하나
    private String content; // 메시지 내용

    // 기본 생성자
    public Message() {}

    // 생성자
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    // Getter & Setter
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}