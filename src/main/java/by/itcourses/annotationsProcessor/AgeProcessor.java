package by.itcourses.annotationsProcessor;


import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;
import by.itcourses.annotations.Age;

import java.lang.reflect.Field;

public class AgeProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {

        try {
            int max = field.getAnnotation(Age.class).max();
            int min = field.getAnnotation(Age.class).min();
            Integer age = (Integer) field.get(obj);
            if(age > max || age < min){
                throw new ValidationException("Invalid input format of age! It should be a number between 0 and 120!\n");
            }
        } catch (IllegalAccessException e) {e.printStackTrace();}
        }
}
