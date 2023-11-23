package com.Inventoryservice.controller;




import com.Inventoryservice.entity.Item;

import com.Inventoryservice.entity.MyItemList;
import com.Inventoryservice.service.ItemService;
import com.Inventoryservice.service.MyItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;
    @Autowired
    private MyItemListService myItemService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/item_register")
    public String itemRegister(){
        return "redirect:/item_register";

    }
    @GetMapping("/available_items")
    public ModelAndView getAllItem(){
        List<Item>list=service.getAllItem();
        ModelAndView m=new ModelAndView();
        m.setViewName("itemList");
        m.addObject("item",list);
        return new ModelAndView("itemList","item",list);
    }

    @GetMapping("/my_items")
    public String getMyItems(Model model){
        List<MyItemList>list=myItemService.getAllMyItems();
        model.addAttribute("item",list);
        return "myItems";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Item b=service.getItemById(id);
        MyItemList mb=new MyItemList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        service.deleteById(id);
        myItemService.saveMyItems(mb);
        return "redirect:http://localhost:8080/inventory-service/available_items";
    }

    @RequestMapping("/editItem/{id}")
    public String editItem(@PathVariable("id") int id, Model model){
        Item b=service.getItemById(id);
        model.addAttribute("item",b);
        return "itemEdit";
    }
    @PostMapping("/save")
    public String addItem(@ModelAttribute Item b){
        service.save(b);
        return "redirect:http://localhost:8080/inventory-service/available_items";
    }
    @RequestMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:http://localhost:8080/inventory-service/available_items";
    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:http://localhost:8080/login-service";
    }
}