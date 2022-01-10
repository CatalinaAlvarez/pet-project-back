package com.example.BackPetProject.DTO;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private String id;
    private String userName;
    private String firstNames;
    private String lastNames;
    private String photo;
    private String email;


    public UserDto(){

    }

    public UserDto(String id, String userName, String firstNames, String lastNames, String photo, String email) {
        this.id = id;
        this.userName = userName;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.photo = photo;
        this.email = email;
    }

    public UserDto(String userName, String firstNames, String lastNames, String photo, String email) {
        this.userName = userName;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.photo = photo;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
