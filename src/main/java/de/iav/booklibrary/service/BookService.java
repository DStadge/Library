package de.iav.booklibrary.service;

import de.iav.booklibrary.model.Book;
import de.iav.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {

    private final BookRepository bookList;


    public BookService(BookRepository bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList.getBookList();
    }

    public Book getBookByISBN(int isbn) {
        return bookList.getBookByISBN(isbn);
    }

    public Book getBookById(String id) {
        return bookList.getBookById(id);
    }




    public void addBook(Book bookToAdd) {

        bookList.addBook(bookToAdd.withId());

    }

    public void deleteBookByISBN(int isbn) {
        bookList.deleteOneBookByIsbn(isbn);
    }

    public Book bookToChange(String id, Book newBook) {
        return bookList.bookToChange(id, newBook);
    }

}

