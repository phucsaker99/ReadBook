package com.example.readbook.model;

import androidx.annotation.DrawableRes;

public class Book {
    private int image;
    private String title;
    private String chapter;
    private String author;
    private String update;
    private String postDate;
    private String category;
    private String status;

    public Book(int image, String title, String chapter, String author, String update, String postDate, String category, String status) {
        this.image = image;
        this.title = title;
        this.chapter = chapter;
        this.author = author;
        this.update = update;
        this.postDate = postDate;
        this.category = category;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
