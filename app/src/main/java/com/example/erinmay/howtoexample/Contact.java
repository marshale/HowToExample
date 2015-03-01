package com.example.erinmay.howtoexample;

/**
 * Created by erinmay on 2/25/15.
 */
public class Contact {

    private String _name, _username, _phone, _email;

    public Contact (String name, String username, String phone, String email) {
        _name = name;
        _username = username;
        _phone = phone;
        _email = email;

    }

    public String getName() {
        return _name;
    }

    public String getUsername() {
        return _username;
    }

    public String getPhone() {
        return _phone;
    }

    public String getEmail() {
        return _email;
    }

}