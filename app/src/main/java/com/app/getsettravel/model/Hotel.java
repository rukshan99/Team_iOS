package com.app.getsettravel.model;


public class Hotel {
    private int id;
    private String HotelName, WebSite, Location, ContactPersonName, Email, MobileNo, Budget, description;

    public Hotel() {

    }

    public Hotel(int id, String hotelName, String webSite, String location, String contactPersonName, String email, String mobileNo, String budget, String description) {
        this.id = id;
        this.HotelName = hotelName;
        this.WebSite = webSite;
        this.Location = location;
        this.ContactPersonName = contactPersonName;
        this.Email = email;
        this.MobileNo = mobileNo;
        this.Budget = budget;
        this.description = description;
    }

    public Hotel(String hotelName, String webSite, String location, String contactPersonName, String email, String mobileNo, String budget, String description) {
        this.HotelName = hotelName;
        this.WebSite = webSite;
        this.Location = location;
        this.ContactPersonName = contactPersonName;
        this.Email = email;
        this.MobileNo = mobileNo;
        this.Budget = budget;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getContactPersonName() {
        return ContactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        ContactPersonName = contactPersonName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}