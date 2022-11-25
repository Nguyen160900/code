package com.example.driver_license_test.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    private List<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
