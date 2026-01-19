package com.practice.Library.controller;

import com.practice.Library.dto.BooksDTO;
import com.practice.Library.service.BooksService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public BooksDTO getParticularBookById(@PathVariable Long bookId) {
        return booksService.getParticularBookById(bookId);
    }

    @PostMapping
    public BooksDTO addNewbook(@RequestBody BooksDTO bookToBeAdded) {
        return booksService.addNewBook(bookToBeAdded);
    }

    @PutMapping("/{id}")
    public BooksDTO updateBook(@PathVariable @Valid Long id, @RequestBody BooksDTO updatedBookDTO) {
        return booksService.updateExistingBook(id, updatedBookDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return booksService.deleteBook(id);
    }

    @GetMapping("/{id}/availability")
    public Boolean checkAvailability(@PathVariable Long id) {
        return booksService.checkAvailability(id);
    }

}
