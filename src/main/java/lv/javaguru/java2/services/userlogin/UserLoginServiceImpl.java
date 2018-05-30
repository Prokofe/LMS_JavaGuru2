package lv.javaguru.java2.services.userlogin;


import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.userregistration.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginValidator validator;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserLoginResponse login(UserLoginRequest request) {
        // validate login and password
        List<Error> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new UserLoginResponse(validationErrors);
        }

        return new UserLoginResponse(request.getLogin(), true, new ArrayList<>());
    }
}
