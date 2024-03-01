package com.example.demo.repository;

import com.example.demo.entity.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyBooksRepo extends JpaRepository<MyBooks,Integer> {
}
