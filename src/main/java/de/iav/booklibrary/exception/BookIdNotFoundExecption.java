package de.iav.booklibrary.exception;

import java.util.NoSuchElementException;

public class BookIdNotFoundExecption extends NoSuchElementException {

    public BookIdNotFoundExecption(String id) {

        super("Book mit der ID " + id + " konnte nicht gefunden werden.");
    }
}
