package com.example.demo.contorller;


import com.example.demo.service.mybookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mybookcontroller {
    @Autowired
    private mybookService mys;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        mys.deleteById(id);
        return "redirect:/mybooks";
    }
}
