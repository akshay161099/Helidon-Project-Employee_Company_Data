package io.helidon.examples.quickstart.mp;

import java.io.Serializable;

public class Company  {
    private int id;
    private String title;
    private int year;

    public static Company of(int id, String title, int year) {
        Company data = new Company();
        data.setId(id);
        data.setTitle(title);
        data.setYear(year);

        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id='" + id + '\'' +
                ",Job title='" + title + '\'' +
                ", Year='" + year + '\'' +
                '}';
    }
}