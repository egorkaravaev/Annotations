package by.itcourses.annotationsProcessor;


import by.itcourses.annotations.Phone;
import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {
        try {
            String format = field.getAnnotation(Phone.class).format();
            Integer phone = (Integer) field.get(obj);
            Pattern pattern = Pattern.compile(format);
            Matcher matcher = pattern.matcher(phone.toString());
            if(!matcher.matches()) {
                throw new ValidationException("Invalid input format of phone number! It should be 7 numbers.\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
