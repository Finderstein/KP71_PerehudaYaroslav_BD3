package com.lab3;

import com.lab3.models.*;

import java.util.List;

class View {
    void show_from_table_authors(List<Author> authors, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Authors");
        }
        try {
           for (Author author : authors) {
                System.out.println("-----------------------------------");
                System.out.println("AuthorID: " + author.authorId);
                System.out.println("AuthorName: " + author.authorName);
                System.out.println("DateOfBirth: " + author.dateOfBirth);
                System.out.println("Biography: " + author.biography);
            }
            System.out.println("-----------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void show_from_table_books(List<Book> books, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Books");
        }
        try {
            for (Book book : books){
                System.out.println("-----------------------------------");
                System.out.println("BookID: " + book.bookId);
                System.out.println("BookAuthor: " + book.bookAuthor);
                System.out.println("BookName: " + book.bookName);
                System.out.println("Genre: " + book.genre);
                System.out.println("Year: " + book.year);
                System.out.println("Pages: " + book.pages);
            }
            System.out.println("-----------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void show_from_table_readers(List<Reader> readers, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Readers");
        }
        try {
            for (Reader reader : readers){
                System.out.println("-----------------------------------");
                System.out.println("ReaderID: " + reader.readerId);
                System.out.println("ReaderName: " + reader.readerName);
                System.out.println("PhoneNumber: " + reader.phoneNumber);
                System.out.println("Address: " + reader.address);
            }
            System.out.println("-----------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void show_from_table_reading(List<Reading> readings, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Reading");
        }
        try {
            for (Reading reading : readings){
                System.out.println("-----------------------------------");
                System.out.println("ReadingID: " + reading.readingId);
                System.out.println("Reader: " + reading.reader);
                System.out.println("Book: " + reading.book);
                System.out.println("Started: " + reading.started);
                System.out.println("Finished: " + reading.finished);
                System.out.println("ReadPages: " + reading.readPages);
            }
            System.out.println("-----------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void showMainMenu() {
        System.out.println("-+-+-+-+- Main Menu -+-+-+-+-");
        System.out.println("Choose table or operation: ");
        System.out.println("1) Table Authors");
        System.out.println("2) Table Books");
        System.out.println("3) Table Readers");
        System.out.println("4) Table Reading");
        System.out.println("5) Search from 2 tables");
        System.out.println("6) Text search");
        System.out.println("7) Generate random");
        System.out.println("8) Exit");
        System.out.print("-> ");
    }

    void showMenuTableOperations(String tableName){
        System.out.println("-+-+-+-+- Table " + tableName + " Menu -+-+-+-+-" );
        System.out.println("1) Read");
        System.out.println("2) Create");
        System.out.println("3) Update");
        System.out.println("4) Delete");
        System.out.println("5) To Main Menu");

        System.out.print("-> ");
    }

    void showSearchFrom2Tables(List<AuthorAndBook> authorAndBooks){
        try{
            for (AuthorAndBook authorAndBook : authorAndBooks) {
                System.out.println("-----------------------------------");
                System.out.println("AuthorID: " + authorAndBook.authorId);
                System.out.println("AuthorName: " + authorAndBook.authorName);
                System.out.println("DateOfBirth: " + authorAndBook.dateOfBirth);
                System.out.println("Biography: " + authorAndBook.biography);
                System.out.println("BookID: " + authorAndBook.bookId);
                System.out.println("BookAuthor: " + authorAndBook.bookAuthor);
                System.out.println("BookName: " + authorAndBook.bookName);
                System.out.println("Genre: " + authorAndBook.genre);
                System.out.println("Year: " + authorAndBook.year);
                System.out.println("Pages: " + authorAndBook.pages);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void showUpdateMenu1(){
        System.out.println("This data doesn't exist");
        System.out.println("1) Stop operation");
        System.out.println("Anything else) Try again");
        System.out.print("-> ");
    }

    void showUpdateMenu2(){
        System.out.println("1) Update");
        System.out.println("2) Stop operation");
        System.out.println("Anything else) Choose another");
        System.out.print("-> ");
    }

    void showDeleteMenu1(){
        System.out.println("This data doesn't exist");
        System.out.println("1) Stop operation");
        System.out.println("Anything else - Try again");
        System.out.print("-> ");
    }

    void showDeleteMenu2(){
        System.out.println("1) Delete");
        System.out.println("2) Stop operation");
        System.out.println("Anything else - Choose another");
        System.out.print("-> ");
    }

    void showFullTextSearchMenu() {
        System.out.println("1) Word is not included from table Books field BookName");
        System.out.println("2) Phrase search from table Books field BookName");
        System.out.println("3) To main menu");
        System.out.print("-> ");
    }

    void showTextSearchResult(List<Book> books) {
        try {
            for (Book book : books){
                System.out.println("-----------------------------------");
                System.out.println("BookID: " + book.bookId);
                System.out.println("BookAuthor: " + book.bookAuthor);
                System.out.println("BookName: " + book.bookName);
                System.out.println("Genre: " + book.genre);
                System.out.println("Year: " + book.year);
                System.out.println("Pages: " + book.pages);
            }
            System.out.println("-----------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

