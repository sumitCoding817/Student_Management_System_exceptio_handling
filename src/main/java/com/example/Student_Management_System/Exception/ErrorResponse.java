package com.example.Student_Management_System.Exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private Map<String,String >erors;

    public ErrorResponse(LocalDateTime timeStamp, int status, String message, Map<String,String >erors) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.erors = erors;
    }
    public ErrorResponse(
            LocalDateTime timeStamp,
            int status,
            String message) {

        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErorss() {
        return erors;
    }

}
