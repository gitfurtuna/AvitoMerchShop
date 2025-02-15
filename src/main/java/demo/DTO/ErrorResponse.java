package demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    @JsonProperty("message")
    private String message;

    public ErrorResponse(@JsonProperty("message") String message) {
        this.message = message;
    }
}
