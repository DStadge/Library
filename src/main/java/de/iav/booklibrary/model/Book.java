package de.iav.booklibrary.model;

import java.util.UUID;

public record Book(
        String id,
        int isbn,
        String title,
        String autor,

        Art art
) {
    public Book withId() {
        return new Book(UUID.randomUUID().toString(), this.isbn, this.title, this.autor, this.art);
    }


}
