package by.itcourses;

import by.itcourses.annotations.*;

public class Person {
    @FormattedString(format = "[A-Za-z]+")
    private String name;
    @FormattedString(format = "[A-Za-z]+")
    private String surname;
    @Age(max = 120, min = 0)
    private Integer age;
    @Height(max = 210, min = 10)
    private Integer height;
    @Weight(max = 200, min = 5)
    private Integer weight;
    @Sex
    private String sex;
    @Phone(format = "[0-9]{7}")
    private int phone;
    @Birthday(format = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])")
    private String birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
