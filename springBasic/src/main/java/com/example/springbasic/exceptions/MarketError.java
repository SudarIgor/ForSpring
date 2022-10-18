package com.example.springbasic.exceptions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MarketError {
    private List<String> messages;
    private Date date;

    public MarketError() {
    }

    public MarketError(List<String> messages) {
        this.messages = messages;
        this.date = new Date();
    }

    public MarketError(String messages) {
       this(List.of(messages));
    }

    public MarketError (String...messages){
        this(Arrays.asList(messages));
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
