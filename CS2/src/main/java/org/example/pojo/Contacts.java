package org.example.pojo;

import lombok.Data;


@Data
public class Contacts {
    public String id;
    public String name;
    public String address;
    public String number;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}