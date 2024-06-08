package com.velamdir.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;

    public MessageResponse(String restaurantDeletedSuccessfully) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}