package dev.Innocent.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDTO {
    private String username;
    private String password;

    public String toString(){
        return "Registration info: username: " + this.username + " password: " + this.password;
    }
}
