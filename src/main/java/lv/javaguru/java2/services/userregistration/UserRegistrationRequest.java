package lv.javaguru.java2.services.userregistration;

public class UserRegistrationRequest {

    private String login;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;

    public UserRegistrationRequest() {
    }

    public UserRegistrationRequest(String login, String password, String email, String address, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


