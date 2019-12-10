package com.lab3.models;

public class Reading {
    public int readingId;
    public int reader;
    public int book;
    public String started;
    public String finished;
    public int readPages;

    public Reading(int reader, int book, String started, String finished, int readPages) {
        this.reader = reader;
        this.book = book;
        this.started = started;
        this.finished = finished;
        this.readPages = readPages;
    }

    public Reading(int readingId, int reader, int book, String started, String finished, int readPages) {
        this.readingId = readingId;
        this.reader = reader;
        this.book = book;
        this.started = started;
        this.finished = finished;
        this.readPages = readPages;
    }
}
