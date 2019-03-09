package com.aska.store.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by ppalpandi on 3/8/2019.
 */
@Component
public class LoginDTO {
    @NotBlank
    @NotNull
    @Email
    @Pattern(regexp=".+@.+\\..+", message="Invalid email address")
    private String email;
    @NotBlank(message = "Password can not be empty")
    @NotNull(message = "Password can not be empty")
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
