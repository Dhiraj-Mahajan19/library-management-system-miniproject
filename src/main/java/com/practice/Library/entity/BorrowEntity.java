package com.practice.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Borrowers")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;
    private Long bookId;
    private Long memberId;
    private Long returnDate;
    private Long dueDate;
    private Double lateFee;
    private Boolean status;
    private String remarks;

}
