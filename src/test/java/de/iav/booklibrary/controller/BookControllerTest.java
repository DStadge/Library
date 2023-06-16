package de.iav.booklibrary.controller;

import de.iav.booklibrary.model.Art;
import de.iav.booklibrary.model.Book;
import de.iav.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc

public class BookControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @DirtiesContext
    void getAllBooks_When_BookListIstNotEmpty_then_expectsStatusIsOkAndReturnListJasn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"))
        ;
    }

    @Test
    void getOneBook_When_BookExistByGivenId_Then_ExpectsStatusOkAndReturnBook() throws Exception {
        bookRepository.addBook(new Book("1", 123, "Titel", "Autor", Art.E_BOOK));
        int expectedId = 1;
        String exepetTitel = "Titel";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/{id}", expectedId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                            {
                            "id":"1",
                            "isbn":"123",
                            "title":"Titel",
                            "autor":"Autor",
                            "art":"E_BOOK"
                            }
                        """));

    }


}






