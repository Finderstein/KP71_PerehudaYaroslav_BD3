package com.lab3.models;

public class Reader {
    public int readerId;
    public String readerName;
    public String phoneNumber;
    public String address;

    public Reader(String readerName, String phoneNumber, String address) {
        this.readerName = readerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Reader(int readerId, String readerName, String phoneNumber, String address) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
