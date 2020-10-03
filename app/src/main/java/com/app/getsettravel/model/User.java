package com.app.getsettravel.model;

public class User {

    String name,pass,email,add,phone;

    public User(String name, String email, String pass, String add, String phone) {
        this.name = name;
        this.email =email;
        this.pass = pass;
        this.add = add;
        this.phone = phone;
    }
    public User(String name, String email, String add, String phone) {
        this.name = name;
        this.email =email;
        this.add = add;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(){}

    /*public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PHONE = "phone";
    }*/




}
