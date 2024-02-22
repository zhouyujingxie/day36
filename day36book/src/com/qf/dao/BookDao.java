package com.qf.dao;

import com.qf.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDao {
    List<Book> select();

    void insert(Book book);

    void delete(int id);
}
