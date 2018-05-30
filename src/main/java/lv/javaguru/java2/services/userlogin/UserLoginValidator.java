package lv.javaguru.java2.services.userlogin;

import lv.javaguru.java2.services.Error;

import java.util.List;

public interface UserLoginValidator {

    List<Error> validate(UserLoginRequest request);
    
}
