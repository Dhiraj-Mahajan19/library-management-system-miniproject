package com.practice.Library.service;

import com.practice.Library.repository.MembersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

    private final MembersRepository membersRepository;
    private final ModelMapper modelMapper;

    public MembersService(MembersRepository membersRepository, ModelMapper modelMapper) {
        this.membersRepository = membersRepository;
        this.modelMapper = modelMapper;
    }
}
