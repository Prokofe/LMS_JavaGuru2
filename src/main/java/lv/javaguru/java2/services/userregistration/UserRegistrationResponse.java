package lv.javaguru.java2.services.userregistration;

import lv.javaguru.java2.services.Error;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationResponse {

    private String login;
    private String email;
    private boolean success;
    private List<Error> errors;

    public UserRegistrationResponse() {
        this.errors = new ArrayList<>();
    }

    public UserRegistrationResponse(String login, String email, boolean success, List<Error> errors) {
        this.login = login;
        this.email = email;
        this.success = success;
        this.errors = errors;
    }

    public UserRegistrationResponse(List<Error> validationErrors) {
        this.errors = validationErrors;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
