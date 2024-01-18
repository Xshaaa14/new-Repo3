package com.emp.payload;

import java.util.Date;

public class ErrorDetails {
    //here we write what content and msg we want to send to postman


    private Date timestamp;
    private String message;
    private String details;


    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
