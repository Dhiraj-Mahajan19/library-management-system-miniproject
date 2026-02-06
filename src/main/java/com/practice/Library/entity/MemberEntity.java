package com.practice.Library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String firstName;
    private String lastName;
    @Email
    @Length(min = 5, max = 30)
    private String email;
    @Digits(integer = 10, fraction = 0)
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private Boolean membershipStatus;

}
