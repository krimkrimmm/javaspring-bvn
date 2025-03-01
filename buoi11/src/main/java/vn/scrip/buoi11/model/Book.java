package vn.scrip.buoi11.model;

import com.opencsv.bean.CsvBindByName; // Đúng namespace của OpenCSV
public class Book {
    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "author")
    private String author;

    @CsvBindByName(column = "year")
    private int year;
    public Book(String id, String title, String author, int year)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
