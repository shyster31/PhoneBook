package service;

import dao.UserDao;
import entity.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import verification.Verification;

@Service
public class UserService {

    private static final String USER = "user";
    private static final int MIN_PASSWORD_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 5;

    @Autowired
    private UserDao userDao;
    @Autowired
    private Verification verification;

    public User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(USER);
    }

    public boolean isLoginedUser(HttpSession session) {
        return getUserFromSession(session) != null;
    }

    public boolean registration(String firstName,
            String lastName,
            String patronymic,
            String login,
            String password1,
            String password2) {
        if (verification.notLessThan(MIN_NAME_LENGTH, firstName)
                && verification.notLessThan(MIN_NAME_LENGTH, lastName)
                && verification.notLessThan(MIN_NAME_LENGTH, patronymic)
                && verification.isCorrectLogin(login)
                && password1.equals(password2)) {
            
            User user = userDao.getByLogin(login);
            
            if (user == null) {
                userDao.add(User.builder().
                        firstName(firstName).
                        lastName(lastName).
                        patronymic(patronymic).
                        login(login).
                        password(password2).
                        build());
                return true;
            }
        }
        return false;
    }

    public boolean authenticate(String login, String password, HttpSession session) {
        User user = userDao.getByLogin(login);
        if (verification.isCorrectLogin(login)
                && verification.notLessThan(MIN_PASSWORD_LENGTH, password)
                && password.equals(user.getPassword())) {
            session.setAttribute(USER, user);
            return true;
        }
        return false;
    }

    public boolean buttonExitPressed(String exit, HttpSession session) {
        if (exit != null && getUserFromSession(session) != null) {
            session.removeAttribute(USER);
            return true;
        }
        return false;
    }
}
