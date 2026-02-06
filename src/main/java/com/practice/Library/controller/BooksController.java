package com.practice.Library.controller;

import com.practice.Library.dto.BooksDTO;
import com.practice.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService booksService) {
        this.bookService = booksService;
    }

    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public BooksDTO getParticularBookById(@PathVariable Long bookId) {
        return bookService.getParticularBookById(bookId);
    }

    @PostMapping
    public BooksDTO addNewbook(@RequestBody BooksDTO bookToBeAdded) {
        return bookService.addNewBook(bookToBeAdded);
    }

    @PutMapping("/{id}")
    public BooksDTO updateBook(@PathVariable @Valid Long id, @RequestBody BooksDTO updatedBookDTO) {
        return bookService.updateExistingBook(id, updatedBookDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/{id}/availability")
    public Boolean checkAvailability(@PathVariable Long id) {
        return bookService.checkAvailability(id);
    }

}
