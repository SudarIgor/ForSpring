package com.example.springbasic.exceptions;

import java.util.Date;

public class MarketError {
    private String messages;
    private Date date;

    public MarketError() {
    }

    public MarketError(String messages) {
        this.messages = messages;
        this.date = new Date();
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
