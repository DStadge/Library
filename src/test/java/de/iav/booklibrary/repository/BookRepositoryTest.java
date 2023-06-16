package de.iav.booklibrary.repository;

import de.iav.booklibrary.exception.BookIdNotFoundExecption;
import de.iav.booklibrary.model.Art;
import de.iav.booklibrary.model.Book;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRepositoryTest {
/*
    @Test
    void list_whenBooksListIsEmpty_thenReturnEmptyList() {
        // Given - Ist Zustand
        // Instanz = Ein konkretes Objekt vom Typen
        BookRepository bookRepository = new BookRepository();
        // Wie sieht die eigentlich erwartete Liste aus?
        List<Book> expectedBookList = new ArrayList<>();
        int expectedListLength = 0;

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Book> actualBookList = bookRepository.getBookList();

        // Then - Soll Zustand
        assertEquals(actualBookList, expectedBookList);
        assertEquals(expectedListLength, actualBookList.size());
    }*/

    @Test
    void list_whenBooksListHasOneProduct_thenReturnListWithOneBook() {
        // Given - Ist Zustand
        // Produkt erstellen
        Book oneBook = new Book("1", 12, "buchtitel", "AA", Art.HOERBUCH);

        // Erwartete ProduktLISTE erstellen
        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(oneBook);

        // Liste im Repo speicher
        BookRepository bookRepository = new BookRepository(expectedBookList);

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Book> actualBookList = bookRepository.getBookList();

        // Then - Soll Zustand
        assertEquals(expectedBookList, actualBookList);
    }

    @Test
    void list_whenBooksListHasTwoProducts_thenReturnListWithTwoBooks() {
        // Given - Ist Zustand
        // Produkt erstellen
        Book buchTitel = new Book("1", 1233, "buchTitel", "AA", Art.HOERBUCH);
        Book buchTitel2 = new Book("2", 1234, "buchTitel2", "BB", Art.HOERBUCH);

        // Erwartete ProduktLISTE erstellen
        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(buchTitel);
        expectedBookList.add(buchTitel2);
        int expectedListLength = 2;

        // Liste im Repo speicher
        BookRepository bookRepository = new BookRepository(expectedBookList);

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Book> actualBookList = bookRepository.getBookList();

        // Then - Soll Zustand
        assertEquals(expectedBookList, actualBookList);
        assertEquals(expectedListLength, actualBookList.size());
    }

    @Test
    void getBookById_whenProductExistsInList_thenReturnValidBook() {
        // Given - Ist Zustand
        Book buchTitel1 = new Book("1", 123, "buchTitel1", "AA", Art.HOERBUCH);
        Book expectedBook = new Book("2", 3434,"buchTitel2", "BB", Art.E_BOOK);
        String expectedId = expectedBook.id();

        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(buchTitel1);
        expectedBookList.add(expectedBook);


        BookRepository bookRepository = new BookRepository(expectedBookList);

        // When
        Book actualBook = bookRepository.getBookById(expectedId);

        // Then
        assertEquals(expectedBook, actualBook);
    }

    @Test
    void getBookById_whenBookDoesntExist_thenThrowBookNotFoundException() {
        // Given - Ist Zustand
        List<Book> expectedBookList = new ArrayList<>();

        BookRepository bookRepository = new BookRepository(expectedBookList);
        String expectedId = "Diese ID gibt es nicht und die Liste ist eh leer.";

        // When + Then
        assertThrows(BookIdNotFoundExecption.class, () -> bookRepository.getBookById(expectedId));
    }



}
