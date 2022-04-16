package com.example.intc_backend.repository;

import com.example.intc_backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByType(String type);
//    @Query("select a from User a")
    User findByPhoneNumber(String type);
//    List<User> findAll(Pageable pageable)
//    List<Location> findAllByOrderByCLocationIdAsc();
}