package com.example.readbook.model;

import java.util.ArrayList;

public class BookDetails {
    private String description;
    private String title;

    public BookDetails(String title, String description) {
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
