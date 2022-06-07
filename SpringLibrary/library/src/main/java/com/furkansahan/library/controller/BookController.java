package com.furkansahan.library.controller;

import com.furkansahan.library.dao.BookDAO;
import com.furkansahan.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDAO bDAO;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bDAO.getAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id ){
        return bDAO.getById(id);
    }

    @PostMapping("/books")
    public String saveBook(@RequestBody Book book){
        return bDAO.save(book)+".saved to the database";
    }

    @PutMapping("/books/{id}")
    public String updateBook(@RequestBody Book book,@PathVariable int id){
        return bDAO.update(book,id)+". updated to the database.";
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id){
        return bDAO.delete(id)+". deleted from the database";
    }

}
