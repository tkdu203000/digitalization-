/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String name;
    String sex;
    String job;
    int income;
    int age;
    PersonDirectory personDirectory;

    public Person(String id,String name, String sex, String job, int income, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.job = job;
        this.income = income;
        this.age = age;
    }
    public Person(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return id;
    }
    public void setPersonId(String id) {
        this.id = id;
    }


    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonId();
    }


    
    public String getPersonName() {
        return name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    public String getPersonSex() {
        return sex;
    }

    public void setPersonSex(String sex) {
        this.sex = sex;
    }

    public String getPersonJob() {
        return job;
    }

    public void setPersonJob(String job) {
        this.job = job;
    }

    public int getPersonIncome() {
        return income;
    }

    public void setPersonIncome(int income) {
        this.income = income;
    }

    public int getPersonAge() {
        return age;
    }

    public void setPersonAge(int age) {
        this.age = age;
    }
}
