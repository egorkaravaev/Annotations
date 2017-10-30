package by.itcourses.annotationsProcessor;


import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;
import by.itcourses.annotations.Height;

import java.lang.reflect.Field;

public class HeightProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {
        try {
            int max = field.getAnnotation(Height.class).max();
            int min = field.getAnnotation(Height.class).min();
            Integer height = (Integer) field.get(obj);
            if(height > max || height < min){
                throw new ValidationException("Invalid input format of height! It should be a number between 10 and 210!\n");
            }
        } catch (IllegalAccessException e) {e.printStackTrace();}
    }

}
