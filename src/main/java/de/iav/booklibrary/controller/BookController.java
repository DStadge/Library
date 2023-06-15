package de.iav.booklibrary.controller;

import de.iav.booklibrary.model.Book;
import de.iav.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){ this.bookService = bookService;}

@GetMapping("/books")
    public List<Book> getBookList(){
        return bookService.getBookList();
}

@GetMapping("/books/{isbn}")
    public Book getBookByISBN(@PathVariable int isbn){
        return bookService.getBookByISBN(isbn);
}

@PutMapping("/books/{isbn}")
        public Book bookToChange(@PathVariable int isbn, @RequestBody Book newBook) {
    return bookService.bookToChange(isbn, newBook);
}


@PostMapping("/books")
     public void addBook(@RequestBody Book bookToAdd) {bookService.addBook(bookToAdd);}


@DeleteMapping("/books/{isbn}")
public void deleteByISBN(@PathVariable int isbn) {
    bookService.deleteBookByISBN(isbn);
}



/*
    GET /books liefert alle gespeicherten Bücher
    GET /books/0345391802 liefert das Buch mit der ISBN 0345391802
    POST /books speichert ein Buch im Repository mit einer zufälligen Id
    PUT /books/0345391802 um ein Buch zu aktualisieren
    DELETE /books/0345391802 löscht das Buch (z.B. wenn man es verschenkt)
*/














}
