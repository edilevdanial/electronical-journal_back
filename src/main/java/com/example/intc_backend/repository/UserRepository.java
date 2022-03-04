package com.example.intc_backend.repository;

import com.example.intc_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByType(String type);
    User findByPhoneNumber(String type);
//    List<Location> findAllByOrderByCLocationIdAsc();
}