package demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class AuthRequest {

    @NotBlank(message = "Username is mandatory")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @JsonProperty("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
