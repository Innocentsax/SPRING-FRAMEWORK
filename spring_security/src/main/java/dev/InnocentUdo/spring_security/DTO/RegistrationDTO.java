package dev.InnocentUdo.spring_security.DTO;

public class RegistrationDTO {

    private String username;
    private String password;


    public RegistrationDTO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
//        return "RegistrationDTO{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
        return "Registration info: " + this.username + "password: " + this.password;
    }
}
