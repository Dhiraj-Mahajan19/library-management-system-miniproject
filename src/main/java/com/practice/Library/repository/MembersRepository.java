package com.practice.Library.repository;

import com.practice.Library.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<MemberEntity, Long> {

}
