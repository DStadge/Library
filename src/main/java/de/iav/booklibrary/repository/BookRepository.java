package de.iav.booklibrary.repository;


import de.iav.booklibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class BookRepository {

    private List<Book> bookList = new ArrayList<>();


    //mit Consturcter erstellt
    public BookRepository(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    //Buch nach ISBN Nummer suchen
    public Book getBookByISBN(int isbn) {
        for (Book oneBook : bookList) {
            if (oneBook.isbn() == isbn) {
                return oneBook;
            }
        }
        throw new NoSuchElementException("Buch mit der: " + isbn + " nicht gefunden");
    }

    //Buch hinzufügen ohne Rückgabewert
    public void addBook(Book bookToAdd) {
        bookList.add(bookToAdd);
    }

    //Buch nach ISBN löschen ohne Rückgabewert
    public void deleteOneBookByIsbn(int isbn) {
        for (Book oneBook : bookList) {
            if (oneBook.isbn() == isbn) {
                bookList.remove(oneBook);
                return;
            }
        }
        throw new NoSuchElementException("Buch mit der: " + isbn + "nicht gefunden");
    }

    //Buch ändern

    public Book bookToChange(int iSBNToChange, Book newBook) {
        Book bookToChange = this.getBookByISBN(iSBNToChange);
        bookList.remove(bookToChange);
        Book bookToAdd = new Book(iSBNToChange, newBook.Title(), newBook.Autor());
        bookList.add(bookToAdd);
        return (bookToAdd);
    }

    public Book randomID(int id) {
        // double random = Math.random();
        int num = (int) (Math.random() * 999);
        id = num;
        return randomID(id);
    }


}
