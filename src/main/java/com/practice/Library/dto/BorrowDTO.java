package com.practice.Library.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BorrowDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long borrowId;
    @NotNull
    private Long bookId;
    @NotNull
    private Long memberId;
    @NotNull
    private Long returnDate;
    @NotNull
    private Long dueDate;
    @NotNull
    private Double lateFee;
    @NotNull
    private Boolean status;
    @NotNull
    private String remarks;
}
