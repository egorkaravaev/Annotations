package by.itcourses.annotationsProcessor;


import by.itcourses.validation.ValidationException;
import by.itcourses.validation.ValidationProcessor;
import by.itcourses.annotations.Weight;

import java.lang.reflect.Field;

public class WeightProcessor implements ValidationProcessor {

    public void process(Object obj, Field field) throws ValidationException {
        try {
            int max = field.getAnnotation(Weight.class).max();
            int min = field.getAnnotation(Weight.class).min();
            Integer weight = (Integer) field.get(obj);
            if(weight > max || weight < min){
                throw new ValidationException("Invalid input format of weight! It should be a number between 5 and 200!\n");
            }
        } catch (IllegalAccessException e) {e.printStackTrace();}
    }
}
