package by.itcourses.validation;

import java.lang.reflect.Field;

public interface ValidationProcessor {
    void process(Object obj, Field field) throws ValidationException;
}
