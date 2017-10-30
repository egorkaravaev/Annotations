package by.itcourses;

import by.itcourses.validation.Validator;


public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person();

        person.setName("Egor");
        person.setSurname("Karavaev");
        person.setAge(20);
        person.setHeight(185);
        person.setWeight(80);
        person.setSex("male");
        person.setPhone(8587738);
        person.setBirthday("1997-02-18");

        Validator validator = new Validator();
        validator.validate(person);
        for (String s: validator.getErrors()) {
            System.out.println(s);
        }
    }
}
