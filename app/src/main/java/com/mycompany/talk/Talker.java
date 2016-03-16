package com.mycompany.talk;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

/**
 * Created by joshua on 12/17/2015.
 */
public class Talker {

    private UUID mId;
    private String userName;
    private String Gender;
    private String age;
    private String email;
    private LatLng coordinates;
    private String Password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    public LatLng getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }

    public Talker(String name,String password, String sex, String age, String email){
        this.Password = password;
        userName = name;
        Gender = sex;
        this.age = age;
        this.email = email;
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
