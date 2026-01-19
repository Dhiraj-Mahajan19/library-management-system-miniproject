package com.practice.Library.service;

import com.practice.Library.repository.BorrowersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BorrowersService {

    private final BorrowersRepository borrowrersRepository;
    private final ModelMapper modelMapper;

    public BorrowersService(BorrowersRepository borrowrersRepository, ModelMapper modelMapper) {
        this.borrowrersRepository = borrowrersRepository;
        this.modelMapper = modelMapper;
    }
}
