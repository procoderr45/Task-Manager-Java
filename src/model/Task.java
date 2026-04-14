package model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String status;
    private LocalDate date;
    private boolean isDeleted = false;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = "ACTIVE";
        date = LocalDate.now();
    }

    public int getId() {
        return this.id;
    }

    // getters for properties
    public String getTitle() {
        return this.title;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }


    // setters for properties
    public void setTitle(String title) {
        this.title = title;
    }

    public void markDeleted() {
        this.isDeleted = true;
        this.status = "INACTIVE";
    }

}