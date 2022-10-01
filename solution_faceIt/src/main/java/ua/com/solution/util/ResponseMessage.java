package ua.com.solution.util;

import lombok.Getter;
import lombok.Setter;

public class ResponseMessage {
    @Getter
    @Setter
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }
}