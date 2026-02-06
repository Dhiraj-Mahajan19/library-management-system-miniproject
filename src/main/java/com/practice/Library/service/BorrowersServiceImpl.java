package com.practice.Library.service;

import com.practice.Library.dto.BorrowDTO;
import com.practice.Library.entity.BorrowEntity;
import com.practice.Library.repository.BorrowersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowersServiceImpl implements BorrowersService {

    private final BorrowersRepository borrowrersRepository;
    private final ModelMapper modelMapper;

    public BorrowersServiceImpl(BorrowersRepository borrowrersRepository, ModelMapper modelMapper) {
        this.borrowrersRepository = borrowrersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BorrowDTO> getAllBorrowers() {
        List<BorrowEntity> requiredResult = borrowrersRepository.findAll();
        return requiredResult.stream()
                .map(borrower -> modelMapper.map(borrower, BorrowDTO.class))
                .toList();
    }
}
