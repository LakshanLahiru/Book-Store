package com.example.demo.service;


import com.example.demo.entity.MyBooks;
import com.example.demo.repository.MyBooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mybookService {

    @Autowired
    private MyBooksRepo mybr;

    public void saveMybooks(MyBooks mybook){
        mybr.save( mybook);

    }
    public List<MyBooks> getAllBooks(){
        return mybr.findAll();
    }
    public void deleteById(int id) {
        mybr.deleteById(id);
    }
}
