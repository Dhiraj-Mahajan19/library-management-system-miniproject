package com.practice.Library.service;

import com.practice.Library.dto.BooksDTO;
import com.practice.Library.entity.BookEntity;
import com.practice.Library.exceptions.ResourceNotFoundException;
import com.practice.Library.repository.BooksRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BooksRepository booksRepository;
    private final ModelMapper modelMapper;

    public BooksService(BooksRepository booksRepository, ModelMapper modelMapper) {
        this.booksRepository = booksRepository;
        this.modelMapper = modelMapper;
    }

    public List<BooksDTO> getAllBooks() {
        List<BookEntity> allBooks = booksRepository.findAll();
        return allBooks.stream()
                .map(book -> modelMapper.map(book, BooksDTO.class))
                .collect(Collectors.toList());
    }

    public BooksDTO getParticularBookById(Long bookId) {
        if(!isBookPresent(bookId)) throw new ResourceNotFoundException("Book with id " + bookId + " was not found in the database");
        return modelMapper.map(booksRepository.findById(bookId), BooksDTO.class);
    }

    public BooksDTO addNewBook(BooksDTO bookToBeAdded) {
        BookEntity bookToBeAddedEntity = modelMapper.map(bookToBeAdded, BookEntity.class);
        BookEntity saved = booksRepository.save(bookToBeAddedEntity);
        return modelMapper.map(saved, BooksDTO.class);
    }

    public BooksDTO updateExistingBook(@Valid Long id, BooksDTO updatedBookDTO) {
        if(!isBookPresent(id)) throw new ResourceNotFoundException("Book with id " + id + " was not found in the database");
        BookEntity updatedBookEntity = modelMapper.map(updatedBookDTO, BookEntity.class);
        updatedBookEntity.setBookId(id);
        return modelMapper.map(booksRepository.save(updatedBookEntity), BooksDTO.class);
    }

    public String deleteBook(Long id) {
        if(!isBookPresent(id)) return "No book with id " + id + " is present in teh database";
        booksRepository.deleteById(id);
        return "Book with id " + id + " has been deleted successfully.";
    }

    public Boolean checkAvailability(Long id) {
        if(!isBookPresent(id)) throw new ResourceNotFoundException("Book with id " + id + " was not found in the database");
        BookEntity book = modelMapper.map(booksRepository.findById(id), BookEntity.class);
        return book.getAvailabilityStatus();
    }

    private boolean isBookPresent(Long bookId) {
        return booksRepository.existsById(bookId);
    }
}
