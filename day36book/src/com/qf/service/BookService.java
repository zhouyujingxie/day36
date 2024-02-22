package com.qf.service;

import com.qf.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void add(Book book);


    void delete(int id);
}
