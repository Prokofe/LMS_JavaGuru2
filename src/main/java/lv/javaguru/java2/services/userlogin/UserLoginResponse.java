package lv.javaguru.java2.services.userlogin;

import lv.javaguru.java2.services.Error;

import java.util.ArrayList;
import java.util.List;

public class UserLoginResponse {

    private String login;
    private boolean success;
    private List<Error> errors;

    public UserLoginResponse() {
        this.errors = new ArrayList<>();
    }

    public UserLoginResponse(String login, boolean success, List<Error> errors) {
        this.login = login;
        this.success = success;
        this.errors = errors;
    }

    public UserLoginResponse(List<Error> validationErrors) {
        this.errors = validationErrors;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
