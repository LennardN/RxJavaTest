package org.example.msg;

public class Message {
    String content;
    String author;

    public Message(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }
}
