package com.practice.Library.service;

import com.practice.Library.dto.BooksDTO;

import java.util.List;

public interface BookService {

    List<BooksDTO> getAllBooks();

    BooksDTO getParticularBookById(Long bookId);

    BooksDTO addNewBook(BooksDTO bookToBeAdded);

    BooksDTO updateExistingBook(Long id, BooksDTO updatedBookDTO);

    String deleteBook(Long id);

    Boolean checkAvailability(Long id);

}
