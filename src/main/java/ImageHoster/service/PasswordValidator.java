package ImageHoster.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z\\d]).{3,})";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    //This method is used to check the password constraints i.e., whether it matches the PASSWORD_PATTERN
    //returns true if password matches the pattern
    public boolean validate(String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
