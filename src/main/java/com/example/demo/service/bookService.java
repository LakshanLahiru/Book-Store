package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.bookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {
    @Autowired
    private bookRepo br;

    public void save(Book b){
        br.save(b);
    }
    public List<Book> getAll(){
        return br.findAll();
    }
    public Book getBookById(int id){
        return br.findById(id).get();
    }
}
