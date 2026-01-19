package com.practice.Library.repository;

import com.practice.Library.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowersRepository extends JpaRepository<BorrowEntity, Long> {

}
