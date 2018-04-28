package verification;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class Verification {

    private static final String LOGIN_REGEX = "^\\w{3,}";
    private static final String PHONE_REGEX = "^\\+380\\d{9}";
    private static final String PHONE_REGEX2 = "^0\\d{9}";
    private static final String EMAIL_REGEX = "^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\w{2,3}$";
    private static final int MIN_NAME_LENGTH = 4;

    public boolean notLessThan(int length, String text) {
        return text.length() >= length;
    }

    public boolean isCorrectEmail(String email) {
        return isCorrect(EMAIL_REGEX, email);
    }

    public boolean isCorrectPhone(String phone) {
        return isCorrect(PHONE_REGEX, phone) || isCorrect(PHONE_REGEX2, phone);
    }

    public boolean isCorrectLogin(String login) {
        return isCorrect(LOGIN_REGEX, login);
    }

    private boolean isCorrect(String regex, String text) {
        return Pattern.compile(regex).matcher(text).matches();
    }

    public boolean isCorrectItemsData(String firstName,
            String lastName,
            String patronymic,
            String phone,
            String email) {
        return notLessThan(MIN_NAME_LENGTH, firstName)
                && notLessThan(MIN_NAME_LENGTH, lastName)
                && notLessThan(MIN_NAME_LENGTH, patronymic)
                && isCorrectPhone(phone)
                && (email.equals("") || isCorrectEmail(email));
    }
}
