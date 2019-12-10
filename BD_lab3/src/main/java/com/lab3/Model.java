package com.lab3;

import com.lab3.models.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

class Model {
    Connection dbConnection;
    private SqlSessionFactory sqlSessionFactory;

    void make_connection() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            this.sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Connection has been successfully created!");

    }

    void insert_in_table_authors(String name, String dateOfBirth, String biography) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Author author = new Author(name, dateOfBirth, biography);
            session.insert("com.lab3.AuthorsMapper.createAuthor", author);
            session.commit();
            System.out.println("Insertion has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void insert_in_table_books(int authorId, String name, String genre, String year, int pages) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Book book = new Book(authorId, name, genre, year, pages);
            session.insert("com.lab3.BooksMapper.createBook", book);
            session.commit();
            System.out.println("Insertion has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void insert_in_table_readers(String name, String phone, String address) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Reader reader = new Reader(name, phone, address);
            session.insert("com.lab3.ReadersMapper.createReader", reader);
            session.commit();
            System.out.println("Insertion has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void insert_in_table_reading(int reader, int book, String started, String finished, int readPages) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Reading reading = new Reading(reader, book, started, finished, readPages);
            session.insert("com.lab3.ReadingMapper.createReading", reading);
            session.commit();
            System.out.println("Insertion has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    List<Author> select_all_from_table_authors() {
        List<Author> authors = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            authors = session.selectList("com.lab3.AuthorsMapper.selectAllAuthors");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return authors;
    }

    List<Book> select_all_from_table_books() {
        List<Book> Books = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Books = session.selectList("com.lab3.BooksMapper.selectAllBooks");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return Books;
    }

    List<Reader> select_all_from_table_readers() {
        List<Reader> readers = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            readers = session.selectList("com.lab3.ReadersMapper.selectAllReaders");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return readers;
    }

    List<Reading> select_all_from_table_reading() {
        List<Reading> readings = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            readings = session.selectList("com.lab3.ReadingMapper.selectAllReading");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return readings;
    }

    List<Author> select_by_id_from_table_authors(int authorId) {
        List<Author> author = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            author = session.selectList("com.lab3.AuthorsMapper.selectAllAuthors", authorId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return author;
    }

    List<Book> select_by_id_from_table_books(int bookId) {
        List<Book> book = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            book = session.selectList("com.lab3.BooksMapper.selectAllBooks", bookId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return book;
    }

    List<Reader> select_by_id_from_table_readers(int readerId) {
        List<Reader> reader = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            reader = session.selectList("com.lab3.ReadersMapper.selectAllReaders", readerId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return reader;
    }

    List<Reading> select_by_id_from_table_reading(int readingId) {
        List<Reading> reading = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            reading = session.selectList("com.lab3.ReadingMapper.selectAllReading", readingId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return reading;
    }

    void update_in_table_authors(int authorId, String name, String dateOfBirth, String bio) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Author author = new Author(authorId, name, dateOfBirth, bio);
            session.update("com.lab3.AuthorsMapper.updateAuthor", author);
            session.commit();
            System.out.println("Update of Author with ID " + authorId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void update_in_table_books(int bookId, int authorId, String name, String genre, String year, int pages) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Book book = new Book(bookId, authorId, name, genre, year, pages);
            session.update("com.lab3.BooksMapper.updateBook", book);
            session.commit();
            System.out.println("Update of Book with ID " + bookId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void update_in_table_readers(int readerId, String name, String phone, String address) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Reader reader = new Reader(readerId, name, phone, address);
            session.update("com.lab3.ReadersMapper.updateReader", reader);
            session.commit();
            System.out.println("Update of Reader with ID " + readerId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void update_in_table_reading(int readingId, int reader, int book, String started, String finished, int readPages) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Reading reading = new Reading(readingId, reader, book, started, finished, readPages);
            session.update("com.lab3.ReadingMapper.updateReading", reading);
            session.commit();
            System.out.println("Update of Reading with ID " + readingId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void delete_from_table_authors(int authorId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("com.lab3.AuthorsMapper.deleteAuthor", authorId);
            session.commit();
            System.out.println("Delete of Author with ID " + authorId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void delete_from_table_books(int bookId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("com.lab3.BooksMapper.deleteBook", bookId);
            session.commit();
            System.out.println("Delete of Book with ID " + bookId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void delete_from_table_readers(int readerId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("com.lab3.ReadersMapper.deleteReader", readerId);
            session.commit();
            System.out.println("Delete of Reader with ID " + readerId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    void delete_from_table_reading(int readingId){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("com.lab3.ReadingMapper.deleteReading", readingId);
            session.commit();
            System.out.println("Delete of Reading with ID " + readingId + " has been successfully done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    List<AuthorAndBook> search_from_2_tables(String name, int from, int to) {
        List<AuthorAndBook> authorAndBooks = null;
        SqlSession session = sqlSessionFactory.openSession();
        SearchFrom2Tables search = new SearchFrom2Tables(name, from, to);
        try {
            authorAndBooks = session.selectList("com.lab3.SearchMapper.selectFrom2Tables", search);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return authorAndBooks;
    }

    List<Book> noWordSearch(String word) {
        List<Book> books= null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            books = session.selectList("com.lab3.SearchMapper.noWordSearch", word);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return books;
    }

    List<Book> phraseSearch(String phrase) {
        List<Book> books= null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            books = session.selectList("com.lab3.SearchMapper.phraseSearch", phrase);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return books;
    }
}

