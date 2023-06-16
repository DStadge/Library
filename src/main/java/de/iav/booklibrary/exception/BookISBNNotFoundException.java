package de.iav.booklibrary.exception;

import java.util.NoSuchElementException;

public class BookISBNNotFoundException extends NoSuchElementException {

    public BookISBNNotFoundException(int isbn) {
        super("Produkt mit der ISBN: " + isbn + " konnte nicht gefunden werden.");
    }
}
