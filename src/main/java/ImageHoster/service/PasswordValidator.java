package ImageHoster.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    //String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
    String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z\\d]).{3,})";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
