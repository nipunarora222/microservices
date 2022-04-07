package com.api.book.services;

import java.util.List;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    

    @Autowired
    private BookRepository bookRepository;

    //get all book
    public List<Book> getAllBooks()
    {
        List<Book> list =(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //get single book by id

    public Book getBookById(int id)
    {       
            Book book = null;
            book = this.bookRepository.findById(id);
             return book;

    }

    // adding books
    public Book addBook(Book b)
    {
        Book result = bookRepository.save(b);
       return result;
    }

    //deleting books
    public void deleteBook(int bid)
    {
        bookRepository.deleteById(bid);
    }

    // updating books
    public void updateBook(Book book, int bookId)
    {
             book.setId(bookId);
             book.setAuthor(book.getAuthor());
            bookRepository.save(book);
    }
}
