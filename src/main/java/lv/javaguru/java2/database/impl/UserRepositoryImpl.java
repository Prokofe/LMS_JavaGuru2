package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl extends ORMRepository implements UserRepository {

    @Override
    public void save(User user) {
        session().save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

}
