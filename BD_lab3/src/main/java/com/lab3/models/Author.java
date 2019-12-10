package com.lab3.models;

public class Author {
    public int authorId;
    public String authorName;
    public String dateOfBirth;
    public String biography;

    public Author(String authorName, String dateOfBirth, String biography) {
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
    }

    public Author(int authorId, String authorName, String dateOfBirth, String biography) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
    }
}
