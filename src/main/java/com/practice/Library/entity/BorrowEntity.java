package com.practice.Library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Borrowers")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowId;
    private Long bookId;
    private Long memberId;
    private Long returnDate;
    private Long dueDate;
    private Double lateFee;
    private Boolean status;
    private String remarks;

}
