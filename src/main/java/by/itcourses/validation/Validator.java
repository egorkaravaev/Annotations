package by.itcourses.validation;

import by.itcourses.annotationsProcessor.*;
import by.itcourses.annotations.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Validator {
    private ArrayList<String> errors = new ArrayList<String>();

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void validate(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(Age.class)){
                try {
                    new AgeProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(FormattedString.class)){
                try {
                    new FormattedStringProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(Phone.class)){
                try {
                    new PhoneProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(Height.class)){
                try {
                    new HeightProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(Sex.class)){
                try {
                    new SexProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(Weight.class)){
                try {
                    new WeightProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            } else if(field.isAnnotationPresent(Birthday.class)){
                try {
                    new BirthdayProcessor().process(obj, field);
                } catch (ValidationException e) {
                    errors.add(e.getMessage());
                }
            }
        }

    }
}
