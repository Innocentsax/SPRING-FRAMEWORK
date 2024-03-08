package dev.InnocentUdo.DTO.response;

import dev.InnocentUdo.enums.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
