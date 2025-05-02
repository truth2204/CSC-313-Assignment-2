package com.example.csc313assignment2.model;

import java.util.ArrayList;
import java.util.List;

public class TextbookRepository {
    private static final List<Textbook> textbooks = new ArrayList<>();

    public static boolean addTextbook(Textbook textbook) {
        if (!textbooks.contains(textbook)) {
            textbooks.add(textbook);
            return true; // Successfully added
        }
        return false; // Duplicate
    }

    public static List<Textbook> getAllTextbooks() {
        return new ArrayList<>(textbooks);
    }

    public static List<Textbook> searchByTitle(String title) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook book : textbooks) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public static List<Textbook> searchBySeller(String seller) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook book : textbooks) {
            if (book.getSeller().toLowerCase().contains(seller.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
}
