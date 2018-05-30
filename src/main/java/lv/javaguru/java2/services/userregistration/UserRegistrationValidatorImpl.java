package lv.javaguru.java2.services.userregistration;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class UserRegistrationValidatorImpl implements UserRegistrationValidator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Error> validate(UserRegistrationRequest request) {
        List<Error> errors = new ArrayList<>();
        validateLogin(request.getLogin()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new Error("login", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new Error("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return Optional.of(new Error("email", "Must not be empty"));
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return Optional.of(new Error("email", "Wrong email format"));
        } else
            return Optional.empty();
    }

    private Optional<Error> validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            return Optional.of(new Error("address", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return Optional.of(new Error("phone", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicateLogin(String login) {
        if (login != null && !login.isEmpty()) {
            Optional<User> userOpt = userRepository.findByLogin(login);
            if (userOpt.isPresent()) {
                return Optional.of(new Error("login", "There's already registered with that name"));
            }
        }
        return Optional.empty();
    }

}
