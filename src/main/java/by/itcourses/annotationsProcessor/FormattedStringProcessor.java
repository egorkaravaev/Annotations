package by.itcourses.annotationsProcessor;

import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;
import by.itcourses.annotations.FormattedString;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormattedStringProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {

        try {
            String format = field.getAnnotation(FormattedString.class).format();
            String fieldValue = (String) field.get(obj);
            Pattern p = Pattern.compile(format);
            Matcher m = p.matcher(fieldValue);
            if(!m.matches()){
                if(field.getName().equals("name")) {
                    throw new ValidationException("Invalid input format of name! It should be only letters.\n");
                }else if(field.getName().equals("surname")){
                    throw new ValidationException("Invalid input format of surname! It should be only letters.\n");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
