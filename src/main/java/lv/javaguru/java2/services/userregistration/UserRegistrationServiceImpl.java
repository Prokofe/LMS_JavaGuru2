package lv.javaguru.java2.services.userregistration;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationValidator validator;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserRegistrationResponse register(UserRegistrationRequest request) {

        // validate login and password
        List<Error> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new UserRegistrationResponse(validationErrors);
        }

        User user = new User(
                request.getLogin(),
                request.getPassword(),
                request.getEmail(),
                request.getAddress(),
                request.getPhoneNumber(),
                User.Role.regular,
                false);

        userRepository.save(user);

        return new UserRegistrationResponse(user.getLogin(), user.getEmail(), true, new ArrayList<>());
    }

}
