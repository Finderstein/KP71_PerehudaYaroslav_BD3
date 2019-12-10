package com.lab3.models;

public class Book {
    public int bookId;
    public int bookAuthor;
    public String bookName;
    public String genre;
    public String year;
    public int pages;

    public Book(int bookAuthor, String bookName, String genre, String year, int pages) {
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
    }

    public Book(int bookId, int bookAuthor, String bookName, String genre, String year, int pages) {
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
    }
}
