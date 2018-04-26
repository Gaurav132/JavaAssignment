/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.entity;

/**
 *
 * @author Nishan Dhungana
 */
public class UserProfile {
    private int id;
    private String fullName;
    private String contact;
    private String username;
    private String password;
    
    public UserProfile() {
        
    }

    public UserProfile(int id) {
        this.id = id;
    }

    public UserProfile(int id, String fullName, String contact, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
