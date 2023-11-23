package com.productservice.controller;

import com.productservice.entity.Item;
import com.productservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/item_register")
    public String itemRegister(){
        return "itemRegister";
    }
    @GetMapping("/available_items")
    public String availableItems(){
        return "available_items";
    }
    @GetMapping("/my_items")
    public String myItems(){
        return "my_items";
    }

    @PostMapping("/save")
    public String addItem(@ModelAttribute Item b){
        service.save(b);
        return "redirect:http://localhost:8080/inventory-service/available_items";

    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:http://localhost:8080/login-service";
    }

}