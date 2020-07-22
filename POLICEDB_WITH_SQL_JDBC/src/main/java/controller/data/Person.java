package controller.data;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component


public class Person {


    private int id;
    private String name;
    private String state;
    private int daysArrested;
    private String gender;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDaysArrested(int daysArrested) {
        this.daysArrested = daysArrested;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getState() {
        return state;
    }

    public int getDaysArrested() {
        return daysArrested;
    }

    public String getGender() {
        return gender;
    }


}
