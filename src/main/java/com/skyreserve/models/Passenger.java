package com.skyreserve.models;

public class Passenger {
    private String id;
    private String title;
    private String fullName;
    private int age;
    private String gender;
    private String idType;
    private String idNumber;
    private String phone;
    private Seat selectedSeat;
    private boolean extraBaggage; // mock true if selected 5kg/10kg
    private String mealPreference;

    public Passenger(String title, String fullName, int age, String gender) {
        this.id = java.util.UUID.randomUUID().toString();
        this.title = title;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getId() { return id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Seat getSelectedSeat() { return selectedSeat; }
    public void setSelectedSeat(Seat selectedSeat) { this.selectedSeat = selectedSeat; }

    public boolean isExtraBaggage() { return extraBaggage; }
    public void setExtraBaggage(boolean extraBaggage) { this.extraBaggage = extraBaggage; }

    public String getMealPreference() { return mealPreference; }
    public void setMealPreference(String mealPreference) { this.mealPreference = mealPreference; }
}
