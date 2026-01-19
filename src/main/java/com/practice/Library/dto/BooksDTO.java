package com.practice.Library.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BooksDTO {
    private Long bookId;
    private String title;
    private String author;
    private String description;
    private String genre;
    private LocalDate publicationYear;
    private Boolean availabilityStatus;

}
