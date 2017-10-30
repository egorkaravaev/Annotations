package by.itcourses.annotationsProcessor;


import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;

import java.lang.reflect.Field;

public class SexProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {
        try {
            String fieldValue = (String) field.get(obj);
            if(!fieldValue.equals("male") && !fieldValue.equals("female")){
                throw new ValidationException("Invalid input format of sex! It should be 'male' or 'female'!\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
