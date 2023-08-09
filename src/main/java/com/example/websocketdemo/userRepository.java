package com.example.websocketdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websocketdemo.Model.users;
@Repository
public interface userRepository extends JpaRepository<users, Long> {

}
