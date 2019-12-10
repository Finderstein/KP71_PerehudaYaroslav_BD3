package com.lab3;

import com.lab3.models.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Controller {
    private Model model;
    private View view;
    private Scanner scanner;



    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    void mainMenu() throws IOException {
        int choise = -1;
        scanner = new Scanner(System.in);

        do
        {
            view.showMainMenu();
            choise = Integer.parseInt(scanner.nextLine());
            try {
                if(choise >= 1 && choise <=4)
                    menuTable(choise);
                else if (choise == 5)
                    DynamicSearch();
                else if (choise == 6)
                    fullTextSearchMenu();
                else if (choise == 7)
                    RandomGenMenu();
                else if(choise != 8)
                        System.out.println("Incorrect input");
            } catch (NumberFormatException numberError) {
                System.out.println("Incorrect input!");
            }
        } while (choise != 8);

        scanner.close();
    }

    private void menuTable(int tableNumber) {
        int choise = -1;
        List<String> tableName = new ArrayList<>();
        tableName.add("Authors");
        tableName.add("Books");
        tableName.add("Readers");
        tableName.add("Reading");

        do
        {
            view.showMenuTableOperations(tableName.get(tableNumber - 1));
            try {
                choise = Integer.parseInt(scanner.nextLine());
                switch (choise)
                {
                    case 1:
                        showTableMenu(tableNumber);
                        break;
                    case 2:
                        if(tableNumber == 1)
                            insertInTableAuthors();
                        else if(tableNumber == 2)
                            insertInTableBooks();
                        else if(tableNumber == 3)
                            insertInTableReaders();
                        else if(tableNumber == 4)
                            insertInTableReading();
                        break;
                    case 3:
                        if(tableNumber == 1)
                            updateInTableAuthors();
                        else if(tableNumber == 2)
                            updateInTableBooks();
                        else if(tableNumber == 3)
                            updateInTableReaders();
                        else if(tableNumber == 4)
                            updateInTableReading();
                        break;
                    case 4:
                        if(tableNumber == 1)
                            deleteFromTableAuthors();
                        else if(tableNumber == 2)
                            deleteFromTableBooks();
                        else if(tableNumber == 3)
                            deleteFromTableReaders();
                        else if(tableNumber == 4)
                            deleteFromTableReading();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Incorrect input");
                }
            } catch (NumberFormatException e){
                System.out.println("Incorrect input");
            }
        } while (choise != 5);
    }

    private void showTableMenu(int tableNumber) {
        switch (tableNumber)
        {
            case 1:
                List<Author> authors = model.select_all_from_table_authors();
                view.show_from_table_authors(authors , true);
                break;
            case 2:
                List<Book> books = model.select_all_from_table_books();
                view.show_from_table_books(books , true);
                break;
            case 3:
                List<Reader> readers = model.select_all_from_table_readers();
                view.show_from_table_readers(readers, true);
                break;
            case 4:
                List<Reading> readings = model.select_all_from_table_reading();
                view.show_from_table_reading(readings, true);
                break;
        }

        int choice = -1;
        System.out.println("1) To Table menu");
        do
        {
            System.out.print("-> ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                if(choice != 1)
                {
                    System.out.println("Incorrect input");
                }
            }catch (NumberFormatException e)
            {
                System.out.println("Incorrect input");
            }
        } while (choice != 1);
    }

    private void insertInTableAuthors() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter DateOfBirth(dd/MM/yyyy): ");
        String dateOfBirth = getDate();
        System.out.println("Enter Biography: ");
        String biography = scanner.nextLine();
        model.insert_in_table_authors(name, dateOfBirth, biography);
    }

    private void insertInTableBooks() {
        System.out.println("Enter BookAuthor: ");
        int authorId = getInt();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter Year(yyyy): ");
        String year = scanner.nextLine();
        System.out.println("Enter Pages: ");
        int pages = getInt();

        model.insert_in_table_books(authorId, name, genre, year, pages);
    }

    private void insertInTableReaders() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter PhoneNumber: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        model.insert_in_table_readers(name, phone, address);
    }

    private void insertInTableReading() {
        System.out.println("Enter Reader: ");
        int reader = getInt();
        System.out.println("Enter Book: ");
        int book = getInt();
        System.out.println("Enter Started(dd/MM/yyyy): ");
        String started = getDate();
        System.out.println("Enter Finished(dd/MM/yyyy): ");
        String finished = getDate();
        System.out.println("Enter ReadPages: ");
        int readPages = getInt();

        model.insert_in_table_reading(reader, book, started, finished, readPages);
    }

    private void updateInTableAuthors() {
        System.out.println("-+-+-+ UpdateMenu +-+-+-");
        int authorId;
        int choose = -1;

        do
        {
            System.out.println("Enter AuthorID to update: ");
            authorId = getInt();
            List<Author> author = model.select_by_id_from_table_authors(authorId);

            try {
                if(author == null)
                {
                    view.showUpdateMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if(choose == 1)
                        return;
                }
                else
                {
                    System.out.println("In DB exists this data: ");
                    view.show_from_table_authors(author, false);
                    view.showUpdateMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        System.out.println("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new DatePfBirth: ");
        String dateOfBirth = getDate();
        System.out.println("Enter new Biography: ");
        String bio = scanner.nextLine();

        model.update_in_table_authors(authorId, name, dateOfBirth, bio);
    }

    private void updateInTableBooks() {
        System.out.println("-+-+-+ UpdateMenu +-+-+-");
        int bookId;
        int choose = -1;

        do
        {
            System.out.println("Enter BookID to update: ");
            bookId = getInt();
            List<Book> book = model.select_by_id_from_table_books(bookId);

            try {
                if (book == null)
                {
                    view.showUpdateMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                }
                else
                {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_books(book, false);
                    view.showUpdateMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        System.out.println("Enter BookAuthor: ");
        int authorId = getInt();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter Year(yyyy): ");
        String year = scanner.nextLine();
        System.out.println("Enter Pages: ");
        int pages = getInt();

        model.update_in_table_books(bookId ,authorId, name, genre, year, pages);
    }

    private void updateInTableReaders() {
        System.out.println("-+-+-+ UpdateMenu +-+-+-");
        int readerId;
        int choose = -1;

        do
        {
            System.out.println("Enter ReaderID to update: ");
            readerId = getInt();
            List<Reader> reader = model.select_by_id_from_table_readers(readerId);

            try {
                if (reader == null) {
                    view.showUpdateMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_readers(reader, false);
                    view.showUpdateMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter PhoneNumber: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        model.update_in_table_readers(readerId, name, phone, address);
    }

    private void updateInTableReading() {
        System.out.println("-+-+-+ UpdateMenu +-+-+-");
        int readingId;
        int choose = -1;

        do
        {
            System.out.println("Enter ReadingID to update: ");
            readingId = getInt();
            List<Reading> reading = model.select_by_id_from_table_reading(readingId);

            try {
                if (reading == null) {
                    view.showUpdateMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_reading(reading, false);
                    view.showUpdateMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        System.out.println("Enter Reader: ");
        int reader = getInt();
        System.out.println("Enter Book: ");
        int book = getInt();
        System.out.println("Enter Started(dd/MM/yyyy): ");
        String started = getDate();
        System.out.println("Enter Finished(dd/MM/yyyy): ");
        String finished = getDate();
        System.out.println("Enter ReadPages: ");
        int readPages = getInt();

        model.update_in_table_reading(readingId, reader, book, started, finished, readPages);
    }

    private void deleteFromTableAuthors() {
        System.out.println("-+-+-+ DeleteMenu +-+-+-");
        int authorId;
        int choose = -1;

        do
        {
            System.out.println("Enter AuthorID to delete: ");
            authorId = getInt();
            List<Author> author = model.select_by_id_from_table_authors(authorId);

            try {
                if(author == null)
                {
                    view.showDeleteMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_authors(author, false);
                    view.showDeleteMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        model.delete_from_table_authors(authorId);
    }

    private void deleteFromTableBooks() {
        System.out.println("-+-+-+ DeleteMenu +-+-+-");
        int bookId;
        int choose = -1;

        do
        {
            System.out.println("Enter BookID to delete: ");
            bookId = getInt();
            List<Book> book = model.select_by_id_from_table_books(bookId);

            try {
                if (book == null) {
                    view.showDeleteMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_books(book, false);
                    view.showDeleteMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        model.delete_from_table_books(bookId);
    }

    private void deleteFromTableReaders() {
        System.out.println("-+-+-+ DeleteMenu +-+-+-");
        int readerId;
        int choose = -1;

        do
        {
            System.out.println("Enter ReaderID to delete: ");
            readerId = getInt();
            List<Reader> reader = model.select_by_id_from_table_readers(readerId);

            try {
                if (reader == null) {
                    view.showDeleteMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_readers(reader, false);
                    view.showDeleteMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        model.delete_from_table_readers(readerId);
    }

    private void deleteFromTableReading() {
        System.out.println("-+-+-+ DeleteMenu +-+-+-");
        int readingId;
        int choose = -1;

        do
        {
            System.out.println("Enter ReadingID to delete: ");
            readingId = getInt();
            List<Reading> reading = model.select_by_id_from_table_reading(readingId);

            try {
                if (reading == null) {
                    view.showDeleteMenu1();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        return;
                } else {
                    System.out.println("In db exists this data: ");
                    view.show_from_table_reading(reading, false);
                    view.showDeleteMenu2();
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1)
                        break;
                    else if (choose == 2)
                        return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);

        model.delete_from_table_reading(readingId);
    }

    private int getInt()
    {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Incorrect input. Try again.");
            }
        } while (true);
        return result;
    }

    private String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date1;
        String dateString;
        do {
            try {
                dateString = scanner.nextLine();
                if(dateString.equals("")) return "";
                java.util.Date date = formatter.parse(dateString);
                date1 = new java.sql.Date(date.getTime());
                break;
            }catch (ParseException e){
                System.out.println("Incorrect date format. Correct format is (dd/MM/yyyy). Try again");
            }
        } while (true);
        return  date1.toString();
    }

    private void  DynamicSearch() {
        System.out.println("Enter Name of author: ");
        String name = scanner.nextLine();
        System.out.println("Enter Pages from: ");
        int from = getInt();
        System.out.println("Enter Pages to: ");
        int to = getInt();

        List<AuthorAndBook> authorAndBooks = model.search_from_2_tables(name, from, to);

        view.showSearchFrom2Tables(authorAndBooks);
    }

    private void fullTextSearchMenu() {
        int choise = -1;

        do
        {
            view.showFullTextSearchMenu();
            try {
                choise = Integer.parseInt(scanner.nextLine());
                if(choise == 1)
                    noWordSearchMenu();
                else if (choise == 2)
                    phraseSearchMenu();
                else{
                    if(choise !=3)
                        System.out.println("Incorrect input");
                }
            } catch (NumberFormatException numberError) {
                System.out.println("Incorrect input!");
            }
        } while (choise != 3);
    }

    private void noWordSearchMenu() {
        System.out.println("Enter word to search");
        String wordToSearch = scanner.nextLine();
        List<Book> books = model.noWordSearch(wordToSearch);
        System.out.println("Word Search Result");
        try {
            if (books == null) {
                System.out.println("Nothing was found!");
            } else {
                view.showTextSearchResult(books);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void phraseSearchMenu () {
        System.out.println("Enter phrase to search");
        String phraseToSearch = scanner.nextLine();
        List<Book> books = model.phraseSearch(phraseToSearch);
        System.out.println("Phrase Search Result");
        try {
            if (books == null){
                System.out.println("Nothing was found!");
            } else {
                view.showTextSearchResult(books);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Source https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    private static String getAlphaString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    private static String getNumericString(int n)
    {
        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    private void RandomGenMenu() {
        System.out.println("Enter count of rows to generate in Readers: ");
        int count = getInt();
        if (count <= 0) return;
        Random rnd = new Random();
        for (; count > 0; count--){
            String readerName = getAlphaString(rnd.nextInt(20 + 1) + 1);
            String phoneNumber = getNumericString(rnd.nextInt(12 + 1));
            String address = getAlphaString(rnd.nextInt(30 + 1));

            model.insert_in_table_readers(readerName, phoneNumber, address);
        }
    }
}

