package com.example.demo.contorller;

import com.example.demo.entity.Book;
import com.example.demo.entity.MyBooks;
import com.example.demo.service.bookService;
import com.example.demo.service.mybookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class bookController {

    @Autowired
    private bookService service;

    @Autowired
    private mybookService mybookservice;

    @GetMapping("/")
    public String home() {
        return ("home");
    }
    @GetMapping("/book_registor")
    public String bookregistor() {
        return ("bookregistor");
    }

    @GetMapping("/availablebook")
    public ModelAndView getAllBooks() {
        List<Book> list =service.getAll();
        return new ModelAndView("booklist","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);

        return "redirect:/availablebook";
    }
    @GetMapping("/mybooks")
    public String getMyBooks(Model model ){
        List<MyBooks> list= mybookservice.getAllBooks();
        model.addAttribute("books",list);
        return ("myBookList");
    }

    @RequestMapping("mylist/{id}")
    public String getMyBooks(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        MyBooks mb = new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        mybookservice.saveMybooks(mb);
        return "redirect:/mybooks";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.getBookById(id);
        return "redirect:/available_books";
    }
     
}
