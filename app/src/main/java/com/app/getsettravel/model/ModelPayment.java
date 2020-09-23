package com.app.getsettravel.model;

public class ModelPayment {

    Integer bookingId, customerId, noOfRooms, noOfNights, SecurityNumber, Month, Year;
    String checkInTime, roomType, checkInDate, hotelName,  CardNumber, CardHolder, PaymentDate; //Amount,
    Float bookingCost;

    public ModelPayment(Integer bookingId, Integer customerId, Integer noOfRooms, Integer noOfNights, Integer securityNumber, Integer month, Integer year,
                        String checkInTime, String roomType, String checkInDate, String hotelName, String cardNumber, String cardHolder, String paymentDate, Float bookingCost) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.noOfRooms = noOfRooms;
        this.noOfNights = noOfNights;
        SecurityNumber = securityNumber;
        Month = month;
        Year = year;
        this.checkInTime = checkInTime;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.hotelName = hotelName;
       // Amount = amount;
        CardNumber = cardNumber;
        CardHolder = cardHolder;
        PaymentDate = paymentDate;
        this.bookingCost = bookingCost;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(Integer noOfNights) {
        this.noOfNights = noOfNights;
    }

    public Integer getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(Integer securityNumber) {
        SecurityNumber = securityNumber;
    }

    public Integer getMonth() {
        return Month;
    }

    public void setMonth(Integer month) {
        Month = month;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

  /*  public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    } */

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCardHolder() {
        return CardHolder;
    }

    public void setCardHolder(String cardHolder) {
        CardHolder = cardHolder;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        PaymentDate = paymentDate;
    }

    public Float getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(Float bookingCost) {
        this.bookingCost = bookingCost;
    }
}
