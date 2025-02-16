package com.dk.chatApp.Model;

import lombok.Data;

public class chatMessage{

    private Long id;
    private String sender;
    private String content;

    public chatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public chatMessage(Long id, String sender, String content) {
        this.id = id;
        this.sender = sender;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
