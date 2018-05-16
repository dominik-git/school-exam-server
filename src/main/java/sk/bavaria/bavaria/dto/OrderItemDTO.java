package sk.bavaria.bavaria.dto;

import sk.bavaria.bavaria.model.Status;

import java.util.List;

public class OrderItemDTO {
    private Long id;
    private Status status;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String problemDescription;
    private String carBrand;
    private String carModel;
    private String yearOfMade;
    private String time;
    private List<String> serviceItemNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getYearOfMade() {
        return yearOfMade;
    }

    public void setYearOfMade(String yearOfMade) {
        this.yearOfMade = yearOfMade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getServiceItemNames() {
        return serviceItemNames;
    }

    public void setServiceItemNames(List<String> serviceItemNames) {
        this.serviceItemNames = serviceItemNames;
    }
}
