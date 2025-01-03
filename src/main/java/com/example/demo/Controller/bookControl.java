package com.example.demo.Controller;

import com.example.demo.Repository.BookRepo;
import com.example.demo.model.Book;
import com.example.demo.Service.bookserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/path/books")
public class bookControl {
    private final bookserve bookserve;

    @Autowired
    public bookControl(bookserve bookserve){
        this.bookserve=bookserve;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookserve.addbook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> specificBook(@PathVariable Long id){

        Book book = bookserve.findIt(id);
        return ResponseEntity.ok(book);

    }

    @GetMapping
    public ResponseEntity<Book>

}
