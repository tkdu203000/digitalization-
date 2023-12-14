/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    ArrayList<Person> personList;

    public PersonDirectory() {

        personList = new ArrayList<Person>();

    }
    public Person newPerson(String id){
         Person p = new Person(id);
        personList.add(p);
        return p;
    }

    public Person newPerson(String id,String name, String sex, String job, int income, int age) {

        Person p = new Person(id,name,sex,job,income,age);
        personList.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : personList) {

            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }
    //test
    public String findPersonName(String id) {
        String personid = "";
        for (Person p : personList) {
          
            personid = personid + p.getPersonId();
        }
        return personid; // not found after going through the whole list
    }

    public int getPersonList() {
        return personList.size();
    }
    

}
