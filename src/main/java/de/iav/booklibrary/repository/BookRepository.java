package de.iav.booklibrary.repository;

import de.iav.booklibrary.exception.BookIdNotFoundExecption;
import de.iav.booklibrary.exception.BookISBNNotFoundException;
import de.iav.booklibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class BookRepository {

    private final List<Book> bookList;// "scheinbar überflüssig" = new ArrayList<>();


    //mit Consturcter erstellt
    public BookRepository(List<Book> bookList) {
        this.bookList = bookList;
    }


    public List<Book> getBookList() {
        return bookList;
    }

    //Buch nach ID suchen

    public Book getBookById(String id) {
        for (Book oneBookById : bookList) {
            if (oneBookById.id().equals(id)) {
                return oneBookById;
            }
        }
        throw new BookIdNotFoundExecption(id + "Buch nicht gefunden");
    }


    //Buch nach ISBN Nummer suchen
    public Book getBookByISBN(int isbn) {
        for (Book oneBookByISBN : bookList) {
            if (oneBookByISBN.isbn() == isbn) {
                return oneBookByISBN;
            }
        }
        throw new BookISBNNotFoundException(isbn);
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
        throw new BookISBNNotFoundException(isbn);
    }

    //Buch ändern

    public Book bookToChange(String idToChange, Book newBook) {
        Book bookToChange = this.getBookById(idToChange);
        bookList.remove(bookToChange);
        Book bookToAdd = new Book(idToChange, newBook.isbn(), newBook.title(), newBook.autor(), newBook.art());
        bookList.add(bookToAdd);
        return (bookToAdd);
    }


}
