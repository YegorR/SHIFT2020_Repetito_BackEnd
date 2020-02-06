package ru.cft.shift.repetito.entity.response;

import ru.cft.shift.repetito.entity.UserEntity;

import java.util.List;

public class UserSimpleResponse {
    public UserSimpleResponse(UserEntity user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.paronym = user.getParonym();
        this.price = user.getPrice();
        this.avgMark = user.getAvgMark();
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String paronym;
    private int price;
    private float avgMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getParonym() {
        return paronym;
    }

    public void setParonym(String paronym) {
        this.paronym = paronym;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
}