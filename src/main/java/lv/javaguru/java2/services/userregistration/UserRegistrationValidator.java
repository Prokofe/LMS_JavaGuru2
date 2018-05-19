package lv.javaguru.java2.services.userregistration;

import lv.javaguru.java2.services.Error;

import java.util.List;

public interface UserRegistrationValidator {

    List<Error> validate(UserRegistrationRequest request);

}
