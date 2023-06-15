package de.iav.booklibrary.controller;

import de.iav.booklibrary.model.Book;
import de.iav.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBookList() {
        return bookService.getBookList();
    }

    @GetMapping("/books/{isbn}")
    public Book getBookByISBN(@PathVariable int isbn) {
        return bookService.getBookByISBN(isbn);
    }

    @PutMapping("/books/{id}")
    public Book bookToChange(@PathVariable String id, @RequestBody Book newBook) {
        return bookService.bookToChange(id, newBook);
    }


    @PostMapping("/books")
    public void addBook(@RequestBody Book bookToAdd) {
        bookService.addBook(bookToAdd);
    }


    @DeleteMapping("/books/{isbn}")
    public void deleteByISBN(@PathVariable int isbn) {
        bookService.deleteBookByISBN(isbn);
    }



}
