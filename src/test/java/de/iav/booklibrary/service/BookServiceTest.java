package de.iav.booklibrary.service;

import de.iav.booklibrary.exception.BookIdNotFoundExecption;
import de.iav.booklibrary.model.Art;
import de.iav.booklibrary.model.Book;
import de.iav.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    // mock = Dummy = Gaukelt vor es gäbe ein Objekt von der Klasse
    // Wir nutzen das, um NUR die Zielklasse zu testen (also den ShopService)
    // - nicht das drumherum
    BookRepository bookRepository = mock(BookRepository.class);

    BookService bookService = new BookService(bookRepository);

    @Test
    void getBookByISBN_whenExistingISBN_thenReturnBook() {
        //GIVEN
        int expectedBookISBN = 1;
        Book expectedBook = new Book("1", expectedBookISBN,"AA", "BB", Art.HOERBUCH);

        // Wie soll sich das "gemockte" Repository verhalten?
        // Der Dummy soll das expectedProduct liefern, wenn ein Aufruf von getProductById
        // mit der ID expectedProductId kommt
        when(bookRepository.getBookByISBN(expectedBookISBN)).thenReturn(expectedBook);

        //WHEN
        Book actualBook = bookService.getBookByISBN(expectedBook.isbn());

        //THEN
        assertEquals(expectedBook, actualBook);
        // Sicherstellen, dass getProductById auch WIRKLICH aufgerufen wurde
        verify(bookRepository).getBookByISBN(any());
    }

    @Test
    void listBooks_whenAtLeastOneBooksExists_thenReturnBookList() {
        //GIVEN
        List<Book> expectedBooks = new ArrayList<>(List.of(new Book("1", 123, "Das ist der Titel", "AA", Art.E_BOOK)));
        when(bookRepository.getBookList()).thenReturn(expectedBooks);

        //WHEN
        List<Book> actualProducts = bookService.getBookList();

        //THEN
        assertEquals(expectedBooks, actualProducts);
        verify(bookRepository).getBookList();
    }


    @Test
    void getBookById_whenNonExistingId_thenThrowBookNotFoundException() {
        //GIVEN
        when(bookRepository.getBookById("nonExistingId")).thenThrow(BookIdNotFoundExecption.class);

        //WHEN + THEN
        assertThrows(BookIdNotFoundExecption.class, () -> bookService.getBookById("nonExistingId"));
    }

}
