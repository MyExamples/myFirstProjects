package validator;

import domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User u = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name" , "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email" , "required");
    }
}
