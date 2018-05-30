package lv.javaguru.java2.services.userlogin;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.userregistration.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserLoginValidatorImpl implements UserLoginValidator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Error> validate(UserLoginRequest request) {
        List<Error> errors = new ArrayList<>();
        validateForm(request.getLogin(), request.getPassword()).ifPresent(errors::add);
        validateLogin(request.getLogin(), request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateForm(String login, String password) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new Error("login", "Must not be empty"));
        } else if (password == null || password.isEmpty()){
            return Optional.of(new Error("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateLogin(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            Optional<User> userOpt = userRepository.findByLogin(login);
            if (!userOpt.isPresent()) {
                return Optional.of(new Error("login", "No such user or wrong password"));
            }
            if (!userOpt.get().getPassword().equals(password)){
                return Optional.of(new Error("password", "No such user or wrong password"));
            }
        }
        return Optional.empty();
    }

}
