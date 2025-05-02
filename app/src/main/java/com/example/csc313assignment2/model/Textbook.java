package com.example.csc313assignment2.model;

import java.util.Objects;

public class Textbook {
    private String title;
    private String seller;
    private int copies;
    private double price;

    public Textbook(String title, String seller, int copies, double price) {
        this.title = title;
        this.seller = seller;
        this.copies = copies;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSeller() {
        return seller;
    }

    public int getCopies() {
        return copies;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // To help prevent duplicates: same title and seller
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Textbook)) return false;
        Textbook that = (Textbook) o;
        return title.equalsIgnoreCase(that.title) && seller.equalsIgnoreCase(that.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), seller.toLowerCase());
    }
}
