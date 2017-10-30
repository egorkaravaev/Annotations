package by.itcourses.annotationsProcessor;


import by.itcourses.annotations.Birthday;
import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthdayProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {
        try {
            String format = field.getAnnotation(Birthday.class).format();
            String date = (String) field.get(obj);
            Pattern pattern = Pattern.compile(format);
            Matcher matcher = pattern.matcher(date);
            if(!matcher.matches()) {
                throw new ValidationException("Invalid input format of birthday! It should be yyyy-mm-dd.\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
