package com.api.book.controllers;

import java.util.List;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BookController {

        @Autowired
        private BookService bookService;

        //get all books handler
        @GetMapping("/books")
        public List<Book> getBooks()
        {
            return this.bookService.getAllBooks();
        }


       // get single book handler
        @GetMapping("/books/{id}")
        public Book getBook(@PathVariable("id") int id)
        {
            return bookService.getBookById(id);
        }

        //create new book handler
        @PostMapping("/books")
        public Book addBook(@RequestBody Book book)
        {
            return this.bookService.addBook(book);
        }

        // delete book handler
        @DeleteMapping("/books/{hello}")
        public void deleteBook(@PathVariable("hello") int Id)
        {
            this.bookService.deleteBook(Id);
            System.out.println("data deleted");
        }

        // update book handler
        @PutMapping("/books/{bookId}")
        public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId)
        {
            this.bookService.updateBook(book, bookId);
            return book;
        }

}
